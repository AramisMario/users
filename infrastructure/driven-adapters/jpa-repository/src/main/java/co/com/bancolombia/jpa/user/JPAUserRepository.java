package co.com.bancolombia.jpa.user;
import co.com.bancolombia.jpa.user.userEntity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAUserRepository extends CrudRepository<UserEntity, String>, QueryByExampleExecutor<UserEntity> {
}
