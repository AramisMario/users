package co.com.bancolombia.jpa.role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import co.com.bancolombia.jpa.role.roleEntity.RoleEntity;

public interface JPARoleRepository extends CrudRepository<RoleEntity, Integer>, QueryByExampleExecutor<RoleEntity> {
}
