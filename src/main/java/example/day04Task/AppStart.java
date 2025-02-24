package example.day04Task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        System.out.println("AppStart.main");
        System.out.println("args = " + Arrays.toString(args));
        SpringApplication.run( AppStart.class );
    }
}
