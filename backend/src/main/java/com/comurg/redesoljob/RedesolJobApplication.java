package com.comurg.redesoljob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RedesolJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedesolJobApplication.class, args);
    }

}
