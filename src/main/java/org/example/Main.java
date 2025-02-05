package org.example;

import org.example.animal.Service.IAnimalService;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        IAnimalService animalService=context.getBean(IAnimalService.class);
        String filePath=getFileFromResources("animals.json");
        if (filePath != null) {
            animalService.processAnimals(filePath);
        } else {
            System.err.println("No se encontro el archivo json en resources.");
        }
    }
    private static String getFileFromResources(String fileName) {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            return null;
        }
        try {
            File file = Paths.get(resource.toURI()).toFile();
            return file.getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }
}