package co.com.bancolombia.dto;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;
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
    @Email
    private String email;
    @NotBlank
    private String password;
    //@Positive
    //private int idRol;
    private String birthDate;

}
