package org.example.animal.Service;

import java.util.List;
import java.util.Map;

public interface IAnimalReader {
    List<Map<String, String>> readAnimals(String input);
}
