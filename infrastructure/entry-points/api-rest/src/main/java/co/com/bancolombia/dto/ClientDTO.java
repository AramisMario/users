package co.com.bancolombia.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ClientDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @Pattern(regexp = "^[0-9]+$")
    private String identificationDocument;
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$")
    private String phone;
    // @Email
    @Pattern(regexp = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")
    private String email;
    @NotBlank
    private String password;
    @Min(5)
    @Max(5)
    private Integer idRole;
    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$")
    private String birthDate;
}
