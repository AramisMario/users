package co.com.bancolombia.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

@Getter
@Setter
public class RoleDTO {

    @NotBlank
    private String name;

}
