package org.example;

import org.example.animal.Animal;
import org.example.animal.AnimalType;
import org.example.animal.Service.IAnimalService;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.InputStream;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if(args.length==0){
            System.err.println("Debe proporcionar el nombre del archivo JSON como argumento.");
            return;
        }
        String fileName = args[0];
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        IAnimalService animalService=context.getBean(IAnimalService.class);
        try(InputStream inputStream=Main.class.getClassLoader().getResourceAsStream(fileName)){
            if (inputStream == null) {
                System.err.println("No se encontró el archivo " + fileName + " en resources.");
                return;
            }
            List<Map<String, String>> animalInfo = animalService.getAnimalsFromJson(inputStream);
            Map<AnimalType, List<Animal>> groupedAnimals = animalService.processAnimals(animalInfo);
            animalService.showGroupedAnimals(groupedAnimals);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}