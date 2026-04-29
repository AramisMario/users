package co.com.bancolombia.usecase.createuser;
import co.com.bancolombia.model.baseUser.User;
//import co.com.bancolombia.model.baseUser.gateways.UserRepository;
import co.com.bancolombia.model.userowner.UserOwner;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class CreateUserUseCase {

    //private UserRepository userRepository;
    //private User user;

    public User exect(){
        System.out.println("DESDE CASO DE USO");
        return UserOwner.builder()
        .name("Nelson")
        .lastName("LastName")
        .identificationDocument("Documento")
        .phone("")
        .email("")
        .password("")
        .build();
    }

}
