package co.com.bancolombia.jpa.user;
import co.com.bancolombia.jpa.user.userEntity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
//import java.lang.Integer;

public interface JPAUserRepository extends CrudRepository<UserEntity, Integer>, QueryByExampleExecutor<UserEntity> {
}
