package co.com.bancolombia.usecase.createuser;
import co.com.bancolombia.model.baseUser.User;
import co.com.bancolombia.model.baseUser.gateways.EncryptInterface;
import co.com.bancolombia.model.baseUser.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepository userRepository;
    private final EncryptInterface encrypt;
    //private User user;

    public User exect(User user){
        System.out.println("DESDE CASO DE USO");
        user.setPassword(encrypt.encrypt(user.getPassword()));
        userRepository.save(user);

        return user;
    }

}
