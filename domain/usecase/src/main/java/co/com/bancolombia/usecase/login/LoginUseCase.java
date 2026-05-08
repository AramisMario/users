package co.com.bancolombia.usecase.login;

import java.util.List;
import co.com.bancolombia.model.baseUser.User;
import co.com.bancolombia.model.baseUser.gateways.EncryptInterface;
import co.com.bancolombia.model.baseUser.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class LoginUseCase {
    private final UserRepository userRepository;
    private final EncryptInterface encrypt;

    public User execute(LoginCommand loginCommand){

        User userExample = User.builder().email(loginCommand.getEmail()).build();
        List<User> users = userRepository.findByExample(userExample);
        if(users.isEmpty()){
            throw new RuntimeException("USUARIO NO ENCONTRADO");
        }
        User userFound = users.get(0);
        boolean match = encrypt.matches(loginCommand.getPassword(),userFound.getPassword());
        if(match == false){
            throw new RuntimeException("CONTRASEÑA INCORRECTA");
        }
        return userFound;
    }
}
