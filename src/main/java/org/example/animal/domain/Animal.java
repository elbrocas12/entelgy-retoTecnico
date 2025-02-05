package org.example.animal.domain;

public abstract class Animal {
    private AnimalType type;
    private String onomatopoeia;
    private String species;
    public Animal(String onomatopoeia, AnimalType animalType, String species){
        this.onomatopoeia=onomatopoeia;
        this.type=animalType;
        this.species=species;
    }

    public abstract String getType();

    public void makeSound(){
        System.out.println(onomatopoeia);
    };

    public AnimalType getAnimalType(){
        return type;
    }

    public String getSpecies(){
        return species;
    }

}
