package co.com.bancolombia.usecase.createuser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    // private User user;

    public User execute(CreateUserCommand command) {
        System.out.println("DESDE CASO DE USO");

        Role role = roleRepository.findById(command.getIdRole());
        User user = command.getUser();
        String userAuthenticatedRole = command.getUserAuthenticatedRole();

        user.setRole(role);

        Map<String, List<String>> createpermission = Map.of(
                "Administrator", List.of("Owner"),
                "Owner", List.of("Employee"));

        if (!createpermission.getOrDefault(userAuthenticatedRole, List.of()).contains(role.getName())) {
            throw new RuntimeException("EL ROL NO TIENE PERMISOS PARA CREAR ROL ESPECIFICADO");
        }

        if (user.calcAge() < 18) {
            throw new IllegalArgumentException("El usuario es menor de edad");
        }

        user.setPassword(encrypt.encrypt(user.getPassword()));
        User savedUser = userRepository.save(user);

        return savedUser;
    }

}
