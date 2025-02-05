package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.animal.Service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Bean(name = "json")
    @Primary
    public IAnimalReader animalReaderJson(ObjectMapper objectMapper){
        return new AnimalReaderJsonImpl(objectMapper);
    }

    @Bean(name = "text")
    public IAnimalReader animalReaderText(){
        return new AnimalReaderTextImpl();
    }


    @Bean
    public IAnimalService animalService(IAnimalReader animalReader){
        return new AnimalServiceImpl(animalReader);
    }
}
