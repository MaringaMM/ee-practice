package com.example.equalexpertsapp.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // Create a GsonHttpMessageConverter with a custom Gson instance
        Gson gson = new Gson();
        GsonHttpMessageConverter messageConverter = new GsonHttpMessageConverter(gson);

        // Add the GsonHttpMessageConverter to RestTemplate's message converters
        restTemplate.getMessageConverters().add(messageConverter);

        return restTemplate;
    }
}
