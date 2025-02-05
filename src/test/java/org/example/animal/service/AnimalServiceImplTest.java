package org.example.animal.service;

import org.example.animal.Animal;
import org.example.animal.AnimalType;
import org.example.animal.Service.AnimalServiceImpl;
import org.example.animal.Service.IAnimalService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalServiceImplTest {

    private IAnimalService animalService;

    @BeforeEach
    void setUp(){
        animalService = new AnimalServiceImpl();
    }

    @Test
    void getAnimalsFromJson(){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("animals-test.json");
        List<Map<String, String>> result = animalService.getAnimalsFromJson(inputStream);
        assertNotNull(result);
        assertEquals(3,result.size());

        assertEquals("León", result.get(0).get("species"));
        assertEquals("TERRESTRE", result.get(0).get("type"));
        assertEquals("Rugido", result.get(0).get("onomatopoeia"));

        assertEquals("Tiburón", result.get(1).get("species"));
        assertEquals("ACUATICO", result.get(1).get("type"));
        assertEquals("Splash", result.get(1).get("onomatopoeia"));

        assertEquals("Halcón", result.get(2).get("species"));
        assertEquals("VOLADOR", result.get(2).get("type"));
        assertEquals("Screech", result.get(2).get("onomatopoeia"));
    }

    @Test
    void testProcessAnimals(){
        List<Map<String,String>> animalInfo=List.of(
                Map.of("species", "Perro", "type", "TERRESTRE", "onomatopoeia", "Guau Guau"),
                Map.of("species", "Pez Payaso", "type", "ACUATICO", "onomatopoeia", "Blub Blub"),
                Map.of("species", "Canario", "type", "VOLADOR", "onomatopoeia", "Pío Pío")
        );
        Map<AnimalType, List<Animal>> result = animalService.processAnimals(animalInfo);
        assertTrue(result.containsKey(AnimalType.TERRESTRE));
        assertTrue(result.containsKey(AnimalType.ACUATICO));
        assertTrue(result.containsKey(AnimalType.VOLADOR));

        assertEquals(1, result.get(AnimalType.TERRESTRE).size());
        assertEquals(1, result.get(AnimalType.ACUATICO).size());
        assertEquals(1, result.get(AnimalType.VOLADOR).size());
    }
}
