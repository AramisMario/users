package co.com.bancolombia.model.role.gateways;
import java.util.List;
import co.com.bancolombia.model.role.Role;

public interface RoleRepository {
    Role save(Role role);
    Role findById(int idRole);
    List<Role> findByExample(Role role);
}
