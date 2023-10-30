package com.example.equalexpertsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EqualExpertsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EqualExpertsAppApplication.class, args);
    }

}
