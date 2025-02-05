package org.example.animal;

public class TerrestrialAnimal extends Animal{
    public TerrestrialAnimal(String name, String onomatopoeia, String species) {
        super( onomatopoeia, AnimalType.TERRESTRE, species);
    }


    @Override
    public String getType() {
        return "Animal Terrestre";
    }
}
