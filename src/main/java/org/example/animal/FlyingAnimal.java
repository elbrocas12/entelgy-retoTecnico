package org.example.animal;

public class FlyingAnimal extends Animal{
    public FlyingAnimal(String onomatopoeia, String species) {
        super( onomatopoeia, AnimalType.VOLADOR, species);
    }
    @Override
    public String getType() {
        return "Animal Volador";
    }
}
