package co.com.bancolombia.model.role.gateways;

import co.com.bancolombia.model.role.Role;

public interface RoleRepository {
    Role save(Role role);
    Role findById(int idRole);
}
