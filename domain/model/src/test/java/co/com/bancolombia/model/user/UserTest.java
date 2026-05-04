package co.com.bancolombia.model.user;

import co.com.bancolombia.model.baseUser.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    private User user;


    @Test
    void testGetAge(){
        this.user = User.builder()
            .id(1)
            .name("Name")
            .lastName("LastName")
            .email("email@gmai.com")
            .phone("3456789")
            .password("password")
            .birthDate("1998-05-01")
            .role(null)
            .build();

        int age = user.calcAge();
        assertTrue(age >= 18);
    }



}
