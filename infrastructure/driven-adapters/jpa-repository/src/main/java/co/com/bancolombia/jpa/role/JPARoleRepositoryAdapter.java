package co.com.bancolombia.jpa.role;
import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.jpa.role.roleEntity.RoleEntity;

import java.util.Optional;

import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import co.com.bancolombia.model.role.Role;
import co.com.bancolombia.model.role.gateways.RoleRepository;
@Repository
public class JPARoleRepositoryAdapter extends AdapterOperations<Role, RoleEntity, Integer, JPARoleRepository> implements RoleRepository
// implements ModelRepository from domain
{

    public JPARoleRepositoryAdapter(JPARoleRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Role.class));
    }

    @Override
    public Role findById(int idRole){
        RoleEntity roleEntity = repository.findById(idRole).orElseThrow();
        return Role.builder().id(roleEntity.getId()).name(roleEntity.getName()).build();
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
