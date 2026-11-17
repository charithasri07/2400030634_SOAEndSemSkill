package com.example.tourist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.tourist.entity.Tourist;
import com.example.tourist.repository.TouristRepository;

@SpringBootApplication
public class TouristManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                TouristManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner insertData(TouristRepository repository) {

        return args -> {

            if (repository.count() == 0) {

                Tourist t = new Tourist();

                t.setName("Charitha");
                t.setVisitedDestination("Hyderabad");
                t.setContact("9876543210");

                repository.save(t);

                System.out.println("Tourist record inserted!");
            }
        };
    }
}
