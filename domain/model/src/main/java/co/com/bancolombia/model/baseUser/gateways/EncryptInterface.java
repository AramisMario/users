package co.com.bancolombia.model.baseUser.gateways;

public interface EncryptInterface{
    String encrypt(String info);
    boolean matches(String rawPassword, String encryptedPassword);
}