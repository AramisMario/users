package co.com.bancolombia.usecase.createclient;

import java.util.List;
import co.com.bancolombia.model.baseUser.User;
import co.com.bancolombia.model.baseUser.gateways.EncryptInterface;
import co.com.bancolombia.model.baseUser.gateways.UserRepository;
import co.com.bancolombia.model.role.Role;
import co.com.bancolombia.model.role.gateways.RoleRepository;
import co.com.bancolombia.usecase.createclient.CreateClientCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateClientUseCase {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final EncryptInterface encrypt;

    public User execute(CreateClientCommand command) {
        System.out.println("CREATE CLIENT");

        Role roleExample = Role.builder().name("Client").build();

        List<Role> roles = roleRepository.findByExample(roleExample);
        Role clientRole = roles.get(0);
        User user = command.getUser();

        user.setRole(clientRole);

        user.setPassword(encrypt.encrypt(user.getPassword()));
        User savedUser = userRepository.save(user);

        return savedUser;
    }

}
