package co.com.bancolombia.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super("USER_NOT_FOUND");
    }
}
