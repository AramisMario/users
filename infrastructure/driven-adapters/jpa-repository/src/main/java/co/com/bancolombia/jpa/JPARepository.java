package co.com.bancolombia.jpa;
import co.com.bancolombia.jpa.userEntity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepository extends CrudRepository<UserEntity, String>, QueryByExampleExecutor<UserEntity> {
}
