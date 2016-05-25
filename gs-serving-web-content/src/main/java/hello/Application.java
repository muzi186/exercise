package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by gavin on 16-5-25.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.setProperty("debug", "");
        SpringApplication.run(Application.class, args);
    }
}
