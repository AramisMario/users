package co.com.bancolombia.usecase.createuser;
import co.com.bancolombia.model.baseUser.User;
import co.com.bancolombia.model.baseUser.gateways.EncryptInterface;
import co.com.bancolombia.model.baseUser.gateways.UserRepository;
import co.com.bancolombia.model.role.Role;
import co.com.bancolombia.model.role.gateways.RoleRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final EncryptInterface encrypt;
    //private User user;

    public User exect(CreateUserCommand command/*User user*/){
        System.out.println("DESDE CASO DE USO");

        Role role = roleRepository.findById(command.getIdRole());
        User user = command.getUser();
        user.setRole(role);

        user.setPassword(encrypt.encrypt(user.getPassword()));
        userRepository.save(user);

        return user;
    }

}
