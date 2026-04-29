package co.com.bancolombia.usecase.createuser;
import co.com.bancolombia.model.baseUser.User;
import co.com.bancolombia.model.baseUser.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepository userRepository;
    //private User user;

    public User exect(User user){
        System.out.println("DESDE CASO DE USO");

        userRepository.save(user);

        return user;
    }

}
