package org.example.animal;

public abstract class Animal {
    private String name;
    private AnimalType type;
    private String onomatopoeia;
    private Species species;
    public Animal(String name,String onomatopoeia, AnimalType animalType, Species species){
        this.name=name;
        this.onomatopoeia=onomatopoeia;
        this.type=animalType;
        this.species=species;
    }

    public AnimalType getAnimalType(){
        return type;
    }

    public abstract void makeSound();
}
