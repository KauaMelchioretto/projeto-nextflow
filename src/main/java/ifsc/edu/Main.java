package ifsc.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Executa application.properties que inclusive roda os migrations pelo flyway
        SpringApplication.run(Main.class, args);
        System.out.println("Hello world!");
    }
}