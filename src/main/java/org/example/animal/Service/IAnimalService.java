package org.example.animal.Service;

import org.example.animal.domain.Animal;
import org.example.animal.domain.AnimalType;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface IAnimalService {
    Map<AnimalType, List<Animal>> processAnimals(List<Map<String,String>>animalInfo);
    List<Map<String,String>> getAnimalsFromJson(InputStream inputStream);
    void showGroupedAnimals(Map<AnimalType,List<Animal>>groupedAnimals);
}
