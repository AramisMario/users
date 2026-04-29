package co.com.bancolombia.model.userclient;
//import co.com.bancolombia.model.baseUser.User;
import lombok.Builder;
//import lombok.experimental.SuperBuilder;
//import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
//@SuperBuilder(toBuilder = true)
public class UserClient{

    /*
    UserClient(String name, String lastName, String identificationDocument, String phone, String email, String idRol, String password){
        super(name, lastName, identificationDocument, phone, email, idRol, password);
    }*/

}
