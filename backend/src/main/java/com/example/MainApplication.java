package com.example;

import com.example.model.ExampleEntity;
import com.example.repository.ExampleRepository;
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
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.LocalDate;
import java.util.TimeZone;

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
    CommandLineRunner initDatabase(ExampleRepository exampleRepository) {
        return args -> {
            try {
                exampleRepository.deleteAll();

                ExampleEntity example = new ExampleEntity();
                example.setBirthDate(LocalDate.now());
                example.setName("Example name");
                exampleRepository.save(example);
            } catch (Exception e) {
                logger.error("Falha na criação de registro de exemplo!", e);
            }
        };
    }


}
