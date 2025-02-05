package org.example.animal;

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


    public String getSpecies(){
        return species;
    }

}
