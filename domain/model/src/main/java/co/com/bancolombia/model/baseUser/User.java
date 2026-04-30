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

    protected String name;
    protected String lastName;
    protected String identificationDocument;
    protected String phone;
    protected String email;
    protected Role role;
    protected String password;

}
