package co.com.bancolombia.model.baseUser;
import lombok.experimental.SuperBuilder;
import lombok.Getter;
@Getter
@SuperBuilder(toBuilder = true)
public abstract class User {
    
    protected String name;
    protected String lastName;
    protected String identificationDocument; 
    protected String phone;
    protected String email;
    protected String idRol;
    protected String password;

    /*
    User(String name, String lastName, String identificationDocument, String phone, String email, String idRol, String password){
        
        this.name = name;
        this.lastName = lastName;
        this.identificationDocument = identificationDocument;
        this.phone = phone;
        this.email = email;
        this.idRol = idRol;
        this.password = password;

    }*/
    
}

