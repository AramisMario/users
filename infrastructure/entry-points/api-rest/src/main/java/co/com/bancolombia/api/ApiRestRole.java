package co.com.bancolombia.api;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import co.com.bancolombia.dto.RoleDTO;
import co.com.bancolombia.model.role.Role;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.bancolombia.usecase.createrole.CreateRoleUseCase;
@RestController
@RequestMapping(value = "/apirole", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ApiRestRole {

    private final CreateRoleUseCase createRoleCase;

    @PostMapping(path = "/createrole/path")
    public ResponseEntity createRole(@Valid @RequestBody RoleDTO dto) {
        System.out.println("Api endpoint CREATE ROLE");

        Role role = Role.builder().name(dto.getName())
                .build();

        createRoleCase.exect(role);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Custom-Header", "valor")
                .body("Created ROLE success");
    }

}
