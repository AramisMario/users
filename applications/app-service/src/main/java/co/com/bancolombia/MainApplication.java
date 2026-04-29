package co.com.bancolombia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.boot.
@SpringBootApplication
@ConfigurationPropertiesScan
//@EntityScan(basePackages = "co.com.bancolombia.userEntity")
//@EnableJpaRepositories(basePackages = "co.com.bancolombia.jpa")
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
