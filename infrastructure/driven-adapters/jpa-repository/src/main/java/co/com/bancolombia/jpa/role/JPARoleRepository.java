package co.com.bancolombia.jpa.role;
import co.com.bancolombia.jpa.role.roleEntity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARoleRepository extends CrudRepository<RoleEntity, String>, QueryByExampleExecutor<RoleEntity> {
}
