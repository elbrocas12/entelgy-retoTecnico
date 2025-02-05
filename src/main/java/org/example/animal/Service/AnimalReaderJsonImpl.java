package org.example.animal.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Main;
import org.example.animal.domain.Animal;
import org.example.animal.domain.AnimalType;
import org.example.animal.factory.AnimalFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalReaderJsonImpl implements IAnimalReader{


    private final ObjectMapper objectMapper;

    @Autowired
    public AnimalReaderJsonImpl(ObjectMapper objectMapper){
        this.objectMapper=objectMapper;
    }

    @Override
    public List<Map<String, String>> readAnimals(String input) {
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(input)) {
            if (inputStream == null) {
                System.err.println("No se encontró el archivo " + input + " en resources.");
                return List.of();
            }
            List<Map<String,String>>animalInfo=objectMapper.readValue(
                    inputStream,
                    new TypeReference<>() {});
            return animalInfo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
