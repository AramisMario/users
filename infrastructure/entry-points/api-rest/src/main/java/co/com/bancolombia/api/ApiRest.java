package co.com.bancolombia.api;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import co.com.bancolombia.dto.UserDTO;
//import co.com.bancolombia.model.role.Role;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import co.com.bancolombia.model.baseUser.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
//import co.com.bancolombia.model.role.gateways.RoleRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.bancolombia.usecase.createuser.CreateUserCommand;
import co.com.bancolombia.usecase.createuser.CreateUserUseCase;
/**
 * API Rest controller.
 * 
 * Example of how to declare and use a use case:
 * <pre>
 * private final MyUseCase useCase;
 * 
 * public String commandName() {
 *     return useCase.execute();
 * }
 * </pre>
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ApiRest {

    private final CreateUserUseCase createUserCase;
    //private final RoleRepository roleRepository;

    @PostMapping(path = "/createuser/path")
    public ResponseEntity createUser(@Valid @RequestBody UserDTO dto){
        System.out.println("Api endpoint CREATE USER");

        //Role role = roleRepository.findById(dto.getIdRole());

        User user = User.builder().name(dto.getName())
        .lastName(dto.getLastName())
        .identificationDocument(dto.getIdentificationDocument())
        .phone(dto.getPhone())
        .email(dto.getEmail())
        .role(null)
        .password(dto.getPassword())
        .birthDate(dto.getBirthDate())
        .build();

        CreateUserCommand createUserCommand = new CreateUserCommand(user, dto.getIdRole());

        createUserCase.exect(createUserCommand);

        return ResponseEntity
        .status(HttpStatus.CREATED)
        .header("Custom-Header", "valor")
        .body("Created success");
    }

}
