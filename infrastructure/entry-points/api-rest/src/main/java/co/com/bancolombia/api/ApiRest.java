package co.com.bancolombia.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import co.com.bancolombia.dto.UserDTO;
import co.com.bancolombia.dto.LoginDTO;
import co.com.bancolombia.dto.UserIdDTO;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

import co.com.bancolombia.model.authenticateduser.AuthenticatedUser;
import co.com.bancolombia.model.baseUser.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import co.com.bancolombia.api.services.JwtService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.bancolombia.usecase.createuser.CreateUserCommand;
import co.com.bancolombia.usecase.createuser.CreateUserUseCase;
import co.com.bancolombia.usecase.login.LoginCommand;
import co.com.bancolombia.usecase.login.LoginUseCase;
import co.com.bancolombia.usecase.verifyOwner.VerifyOwnerCommand;
import co.com.bancolombia.usecase.verifyOwner.VerifyOwnerUseCase;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ApiRest {

    private final CreateUserUseCase createUserUseCase;
    private final VerifyOwnerUseCase verifyOwnerUseCase;
    private final JwtService jwtService;
    private final LoginUseCase loginUseCase;

    @PostMapping(path = "/createuser/path")
    public ResponseEntity<ApiResponseBody<User>> createUser(@Valid @RequestBody UserDTO dto) {
        System.out.println("Api endpoint CREATE USER");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // String userId = authentication.getName();

        String authenticatedRole = authentication.getAuthorities()
                .iterator()
                .next()
                .getAuthority().substring(5);

        // AuthenticatedUser authenticatedUser = new AuthenticatedUser(
        // Integer.valueOf(userId),
        // authenticatedRole);

        System.out.println("AUTHENTICADES USER: " + authenticatedRole);

        User user = User.builder().name(dto.getName())
                .lastName(dto.getLastName())
                .identificationDocument(dto.getIdentificationDocument())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .role(null)
                .password(dto.getPassword())
                .birthDate(dto.getBirthDate())
                .build();

        CreateUserCommand createUserCommand = CreateUserCommand.builder()
                .user(user)
                .idRole(dto.getIdRole())
                .userAuthenticatedRole(authenticatedRole)
                .build();

        User savedUser = createUserUseCase.execute(createUserCommand);

        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setHttpStatus(HttpStatus.CREATED);
        apiResponse.setData(
                new ApiResponseBody<User>("CREATED", "Usuario creado", savedUser));
        return apiResponse.response();
    }

    @PostMapping(path = "/verifyowner/path")
    public ResponseEntity<ApiResponseBody<User>> verifyOwner(@Valid @RequestBody UserIdDTO dto) {

        User user = null;
        ApiResponse<User> apiResponse = new ApiResponse<>();

        try {

            VerifyOwnerCommand verifyOwnerCommand = new VerifyOwnerCommand(dto.getUserId());

            user = verifyOwnerUseCase.execute(verifyOwnerCommand);

            apiResponse.setHttpStatus(HttpStatus.OK);
            apiResponse.setData(
                    new ApiResponseBody<User>("OK", "El usurio es Owner", user));

        } catch (Exception e) {
            switch (e.getMessage()) {
                case "USER_NOT_OWNER":

                    apiResponse.setHttpStatus(HttpStatus.UNPROCESSABLE_CONTENT);
                    apiResponse.setData(
                            new ApiResponseBody<User>("UNPROCESSABLE_CONTENT", "El usuario no es Owner", null));

                    break;

                case "USER_NOT_FOUND":

                    apiResponse.setHttpStatus(HttpStatus.NOT_FOUND);
                    apiResponse.setData(
                            new ApiResponseBody<User>("NOT_FOUND", "Usuario no encontrado", null));
                    break;

                default:

                    apiResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                    apiResponse.setData(
                            new ApiResponseBody<User>("INTERNAL_SERVER_ERROR", "Error interno del servidor", null));
                    break;
            }
        }

        return apiResponse.response();
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {

        LoginCommand loginCommand = new LoginCommand(dto.getEmail(), dto.getPassword());
        User userLoged = loginUseCase.execute(loginCommand);
        // Integer roleId = userLoged.getRole().getId();
        String roleName = userLoged.getRole().getName();
        System.out.println("ROLENAME: " + roleName);
        // LoginUseCase.e
        // validar usuario y password aquí
        System.out.println("ANTES DE GENERAR EL TOKEN");
        return jwtService.generateToken(userLoged.getId(), roleName);
    }
}
