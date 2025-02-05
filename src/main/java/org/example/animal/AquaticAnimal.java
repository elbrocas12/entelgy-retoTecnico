package org.example.animal;

public class AquaticAnimal extends Animal{
    public AquaticAnimal(String name, String onomatopoeia, String species) {
        super( onomatopoeia, AnimalType.ACUATICO, species);
    }
    @Override
    public String getType() {
        return "Animal acuatico";
    }
}
