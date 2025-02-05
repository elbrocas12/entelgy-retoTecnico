package org.example.animal.domain;

public class TerrestrialAnimal extends Animal{
    public TerrestrialAnimal(String onomatopoeia, String species) {
        super( onomatopoeia, AnimalType.TERRESTRE, species);
    }


}
