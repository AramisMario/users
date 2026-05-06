package co.com.bancolombia.usecase.verifyOwner;

import co.com.bancolombia.model.baseUser.User;
import co.com.bancolombia.model.baseUser.gateways.UserRepository;
import co.com.bancolombia.exceptions.UserNotFoundException;
import co.com.bancolombia.exceptions.UserNotOwnerException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VerifyOwnerUseCase {

    private final UserRepository userRepository;

    public User execute(VerifyOwnerCommand command) {
        System.out.println("DESDE CASO DE USO VERFICAR");

        User user = userRepository.findById(command.getUserId());

        System.out.println("USER: "+user);
        if(user == null){
            throw new UserNotFoundException();
        }

        if(!user.getRole().getName().equals("Owner")){
            throw new UserNotOwnerException();
        }

        return user;
        
    }
}
