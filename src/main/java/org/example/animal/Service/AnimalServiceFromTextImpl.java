package org.example.animal.Service;

import org.example.animal.domain.Animal;
import org.example.animal.domain.AnimalType;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class AnimalServiceFromTextImpl implements IAnimalService{
    @Override
    public Map<AnimalType, List<Animal>> processAnimals(List<Map<String, String>> animalInfo) {
        return Map.of();
    }

    @Override
    public List<Map<String, String>> getAnimalsFromJson(InputStream inputStream) {
        return List.of();
    }

    @Override
    public void showGroupedAnimals(Map<AnimalType, List<Animal>> groupedAnimals) {

    }
}
