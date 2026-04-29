package co.com.bancolombia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
//import co.com.bancolombia.model.userowner.UserOwner;
@SpringBootApplication
@ConfigurationPropertiesScan
public class MainApplication {
    public static void main(String[] args) {
        //System.out.println("MAIN APLICATION");
        SpringApplication.run(MainApplication.class, args);
        /*
        UserOwner userOwn = UserOwner.builder()
        .name("Nelson")
        .lastName("LastName")
        .identificationDocument("Documento")
        .phone("")
        .email("")
        .password("")
        .build();
        userOwn.getName();
        System.out.println("EL NOMBRE: ");
        System.out.println(userOwn.getName());*/
    }
}
