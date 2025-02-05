package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.animal.Service.AnimalServiceImpl;
import org.example.animal.Service.IAnimalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
    @Bean
    public IAnimalService animalService(ObjectMapper objectMapper){
        return new AnimalServiceImpl(objectMapper);
    }
}
