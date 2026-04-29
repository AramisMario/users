package co.com.bancolombia.jpa;
import co.com.bancolombia.jpa.userEntity.UserEntity;
import co.com.bancolombia.jpa.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import co.com.bancolombia.model.baseUser.User;
import co.com.bancolombia.model.baseUser.gateways.UserRepository;
@Repository
public class JPARepositoryAdapter extends AdapterOperations<User, UserEntity, String, JPARepository> implements UserRepository
// implements ModelRepository from domain
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, User.class));
    }

    /*
    @Override
    public User saveUser(User user) {

        //UserEntity userEntity = new UserEntity();
        //userEntity.setName(user.getName());
        //userEntity.setLastName(user.getLastName());
        //userEntity.setIdentificationDocument(user.getIdentificationDocument());
        //userEntity.setPhone(user.getPhone());
        //userEntity.setEmail(user.getEmail());
        //userEntity.setPassword(user.getPassword());

        repository.save(userEntity);
        return user;
    }*/
}
