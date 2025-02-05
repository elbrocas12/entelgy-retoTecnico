package org.example.animal.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.example.animal.domain.Animal;
import org.example.animal.domain.AnimalType;
import org.example.animal.factory.AnimalFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalServiceImpl implements IAnimalService{

    private final ObjectMapper objectMapper;
    @Autowired
    public AnimalServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @Override
    public Map<AnimalType, List<Animal>> processAnimals(List<Map<String, String>> animalInfo) {
        List<Animal> animals = animalInfo.stream()
                .map(data -> AnimalFactory.createAnimal(
                        data.get("species"),
                        AnimalType.valueOf(data.get("type")),
                        data.get("onomatopoeia")
                ))
                .toList();
        Map<AnimalType, List<Animal>> groupedAnimals = animals.stream()
                .collect(Collectors.groupingBy(Animal::getAnimalType));
        return groupedAnimals;



    }

    @Override
    public List<Map<String, String>> getAnimalsFromJson(InputStream inputStream) {
        try{
            List<Map<String,String>>animalInfo=objectMapper.readValue(
                    inputStream,
                    new TypeReference<>() {});
            return animalInfo;
        } catch (Exception e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        return List.of();
    }

    @Override
    public void showGroupedAnimals(Map<AnimalType,List<Animal>>groupedAnimals) {
        groupedAnimals.forEach((type, animalList) -> {
            System.out.println("\n Animales " + type + ":");
            animalList.forEach(animal -> {
                System.out.println(" - " + animal.getSpecies() + " hace: ");
                animal.makeSound();
            });
        });
    }

}
