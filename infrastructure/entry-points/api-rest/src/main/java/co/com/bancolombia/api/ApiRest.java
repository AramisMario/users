package co.com.bancolombia.api;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import co.com.bancolombia.dto.UserDTO;

import co.com.bancolombia.model.baseUser.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    //private final CreateRoleUseCase createRoleCase;

    @PostMapping(path = "/createuser/path")
    public ResponseEntity createUser(@Valid @RequestBody UserDTO dto){
        System.out.println("Api endpoint CREATE USER");

        
        User user =  User.builder().name("Nelson")
        .lastName("LastName")
        .identificationDocument("12345678")
        .phone("573256784")
        .email("mario@gmail.com")
        .password("password")
        .build();

        createUserCase.exect(user);

        return ResponseEntity
        .status(HttpStatus.CREATED)
        .header("Custom-Header", "valor")
        .body("Created success");
    }

}
