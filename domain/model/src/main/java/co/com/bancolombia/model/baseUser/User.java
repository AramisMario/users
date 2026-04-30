package co.com.bancolombia.model.baseUser;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import co.com.bancolombia.model.role.Role;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String lastName;
    private String identificationDocument;
    private String phone;
    private String email;
    private Role role;
    private String password;
    private String birthDate;

}
