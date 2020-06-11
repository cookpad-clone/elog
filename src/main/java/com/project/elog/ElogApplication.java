package com.project.elog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ElogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElogApplication.class, args);
    }

}
