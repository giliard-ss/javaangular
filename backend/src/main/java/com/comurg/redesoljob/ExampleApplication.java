package com.comurg.redesoljob;

import com.comurg.redesoljob.model.Example;
import com.comurg.redesoljob.repository.ExampleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ExampleRepository exampleRepository) {
        return args -> {
            exampleRepository.deleteAll();

            Example example = new Example();
            example.setName("Example name");
            exampleRepository.save(example);
        };
    }
}
