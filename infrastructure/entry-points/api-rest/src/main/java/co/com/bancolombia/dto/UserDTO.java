package co.com.bancolombia.dto;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;
//import co.com.bancolombia.model.role.Role;
@Getter
@Setter
public class UserDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @Pattern(regexp = "^[0-9]+$")
    private String identificationDocument;
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$")
    private String phone;
    //@Email
    @Pattern(regexp = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")
    private String email;
    @NotBlank
    private String password;
    @Positive
    private Integer idRole;
    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$")
    private String birthDate;

}
