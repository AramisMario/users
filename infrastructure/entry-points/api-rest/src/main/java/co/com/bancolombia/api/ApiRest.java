package co.com.bancolombia.api;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import co.com.bancolombia.dto.UserDTO;
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


    //@GetMapping(path = "/createuser/path")
    //public String commandName() {
    //    System.out.println("Api endpoint CREATE USER");
    //    CreateUserUseCase createUserCase = new CreateUserUseCase();
    //    return createUserCase.exect().toString();
    //}

    @PostMapping(path = "/createuser/path")
    public ResponseEntity createUser(@Valid @RequestBody UserDTO dto){
        System.out.println("Api endpoint CREATE USER");

        /*
        UserOwner userOwn = UserOwner.builder()
        .name("Nelson")
        .lastName("LastName")
        .identificationDocument("Documento")
        .phone("")
        .email("")
        .password("")
        .build();*/

        return ResponseEntity
        .status(HttpStatus.CREATED)
        .header("Custom-Header", "valor")
        .body("Created success");
    }

}
