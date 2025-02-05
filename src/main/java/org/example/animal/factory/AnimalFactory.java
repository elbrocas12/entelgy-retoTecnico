package org.example.animal.factory;

import org.example.animal.domain.*;

public class AnimalFactory {
    public static Animal createAnimal(String species, AnimalType type, String onomatopoeia){
        return switch (type) {
            case TERRESTRE -> new TerrestrialAnimal(onomatopoeia, species);
            case ACUATICO -> new AquaticAnimal(onomatopoeia, species);
            case VOLADOR -> new FlyingAnimal(onomatopoeia, species);
        };
    }
}
