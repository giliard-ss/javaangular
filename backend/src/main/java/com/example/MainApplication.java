package com.example;

import com.example.model.Example;
import com.example.repository.ExampleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @PostConstruct
    public void init(){
        // Setting Spring Boot SetTimeZone
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner initDatabase(ExampleRepository exampleRepository) {
        System.out.println("");
        return args -> {
            try {
                exampleRepository.deleteAll();

                Example example = new Example();
                example.setBirthDate(LocalDate.now());
                example.setName("Example name");
                exampleRepository.save(example);
            }catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
