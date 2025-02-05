package org.example;

import org.example.animal.Service.IAnimalService;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        IAnimalService animalService=context.getBean(IAnimalService.class);
        try(InputStream inputStream=Main.class.getClassLoader().getResourceAsStream("animals.json")){
            if (inputStream != null) {
                animalService.processAnimals(inputStream);
            } else {
                System.err.println("No se encontró el archivo animals.json en resources.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}