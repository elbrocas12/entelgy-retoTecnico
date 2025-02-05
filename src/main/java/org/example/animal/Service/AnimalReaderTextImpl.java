package org.example.animal.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.awt.SystemColor.text;

public class AnimalReaderTextImpl implements IAnimalReader{
    @Override
    public List<Map<String, String>> readAnimals(String input) {
        return Arrays.stream(input.split(",")).map(String::trim)
                .map(this::parseAnimalData).toList();

    }

    private Map<String,String> parseAnimalData(String animal){
        String[] parts=animal.split("-");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Formato inválido para: " + animal +
                    ". El formato debe ser: Especie-TIPO-Onomatopeya");
        }
        return Map.of(
                "species", parts[0].trim(),
                "type", parts[1].trim(),
                "onomatopoeia", parts[2].trim()
        );
    }
}
