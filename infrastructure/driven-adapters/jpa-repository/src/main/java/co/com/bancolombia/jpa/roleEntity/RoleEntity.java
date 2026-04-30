package co.com.bancolombia.jpa.roleEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}