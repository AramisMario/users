package co.com.bancolombia.model.baseUser;
//import lombok.experimental.SuperBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
//import lombok.Setter;
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
    //protected String idRol;
    protected String password;

}

