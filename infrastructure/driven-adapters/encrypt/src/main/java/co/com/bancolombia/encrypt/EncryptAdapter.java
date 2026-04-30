package co.com.bancolombia.encrypt;

import co.com.bancolombia.model.baseUser.gateways.EncryptInterface;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class EncryptAdapter implements EncryptInterface {

    private final PasswordEncoder encoder;

    public EncryptAdapter(){
        this.encoder = new BCryptPasswordEncoder(10);
    }

    public String encrypt(String info) {
        return encoder.encode(info);
    }
}
