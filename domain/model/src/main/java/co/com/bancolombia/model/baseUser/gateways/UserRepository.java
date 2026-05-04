package co.com.bancolombia.model.baseUser.gateways;
//import java.util.List;

import co.com.bancolombia.model.baseUser.User;
public interface UserRepository {

    //User saveUser(User user);
    //<T> User findById(T id);

    User save(User user);
    User findById(Integer id);
    //List<User> saveAll(List<User> users);

}
