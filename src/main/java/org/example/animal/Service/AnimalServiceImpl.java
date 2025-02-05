package org.example.animal.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.example.animal.Animal;
import org.example.animal.AnimalType;
import org.example.animal.factory.AnimalFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalServiceImpl implements IAnimalService{


    @Override
    public void processAnimals(InputStream inputStream) {
        ObjectMapper objectMapper=new ObjectMapper();
        try{
            List<Map<String,String>>animalInfo=objectMapper.readValue(
                    inputStream,
                    new TypeReference<>() {});
            List<Animal> animals = animalInfo.stream()
                    .map(data -> AnimalFactory.createAnimal(
                            data.get("species"),
                            AnimalType.valueOf(data.get("type")),
                            data.get("onomatopoeia")
                    ))
                    .toList();
            Map<AnimalType, List<Animal>> groupedAnimals = animals.stream()
                    .collect(Collectors.groupingBy(Animal::getAnimalType));
            groupedAnimals.forEach((type, animalList) -> {
                System.out.println("\n🔹 Animales " + type + ":");
                animalList.forEach(animal -> {
                    System.out.println(" - " + animal.getSpecies() + " hace: ");
                    animal.makeSound();
                });
            });
        }catch(IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }

    }

}
