package org.example.animal.domain;

public class FlyingAnimal extends Animal{
    public FlyingAnimal(String onomatopoeia, String species) {
        super( onomatopoeia, AnimalType.VOLADOR, species);
    }
}
