package org.example.animal;

public abstract class Animal {
    private String name;
    private AnimalType type;
    private String onomatopoeia;

    public Animal(String name,String onomatopoeia, AnimalType animalType){
        this.name=name;
        this.onomatopoeia=onomatopoeia;
        this.type=animalType;
    }

    public AnimalType getAnimalType(){
        return type;
    }

    public abstract void makeSound();
}
