package co.com.bancolombia.jpa.user.userEntity;

import jakarta.persistence.*;
import co.com.bancolombia.jpa.roleEntity.RoleEntity;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String lastName;
    private String identificationDocument;
    private String phone;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRole")
    private RoleEntity role;

    private String password;

    public void setName(String name){
        this.name = name;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setIdentificationDocument(String identificationDocument){
        this.identificationDocument = identificationDocument;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    
    public void setRole(RoleEntity role){
        this.role = role;
    }


    public void setPassword(String password){
        this.password = password;
    }

}
