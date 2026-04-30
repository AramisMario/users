package co.com.bancolombia.usecase.createrole;

import co.com.bancolombia.model.role.Role;
import co.com.bancolombia.model.role.gateways.RoleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateRoleUseCase {

    private final RoleRepository roleRepository;

    public Role exect(Role role) {
        System.out.println("DESDE CASO DE USO ROLE");

        roleRepository.save(role);

        return role;
    }
}