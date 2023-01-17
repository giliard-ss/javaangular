package com.example;

import com.example.enums.RoleExampleEnum;
import com.example.model.RoleExampleEntity;
import com.example.model.UserExampleEntity;
import com.example.repository.RoleExampleRepository;
import com.example.repository.UserExampleRepository;
import com.example.schedule.ExampleScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.logging.LogManager;

@SpringBootApplication
@EnableScheduling
public class MainApplication {

    private static Logger logger = LoggerFactory.getLogger(MainApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @PostConstruct
    public void init() {
        // Setting Spring Boot SetTimeZone
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
    }

    @Bean
    public RestTemplate restTemplate(Environment env) {
        int connectionTimeout = env.getProperty("rest.connection.timeout", Integer.class);
        int headTimeout = env.getProperty("rest.read.timeout",  Integer.class);

        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(connectionTimeout))
                .setReadTimeout(Duration.ofMillis(headTimeout))
                .build();
    }

    @Bean
    CommandLineRunner initDatabase(UserExampleRepository exampleRepository, RoleExampleRepository roleExampleRepository) {
        return args -> {
            try {
                exampleRepository.deleteAll();
                roleExampleRepository.deleteAll();

                RoleExampleEntity r1 = new RoleExampleEntity();
                r1.setName(RoleExampleEnum.USER);

                RoleExampleEntity r2 = new RoleExampleEntity();
                r2.setName(RoleExampleEnum.ADMIN);

                r1 =roleExampleRepository.save(r1);
                roleExampleRepository.save(r2);



                UserExampleEntity user = new UserExampleEntity();
                user.setUsername("master");
                user.setPassword(new BCryptPasswordEncoder().encode("123456"));
                user.setRoles(new ArrayList<>());
                user.getRoles().add(r1);

                exampleRepository.save(user);
            } catch (Exception e) {
                logger.error("Error initDatabase", e);
            }
        };
    }


}
