package org.example.animal;

public class TerrestrialAnimal extends Animal{
    public TerrestrialAnimal(String name, String onomatopoeia, Species species) {
        super(name, onomatopoeia, AnimalType.TERRESTRE, species);
    }

    @Override
    public void makeSound(){
        System.out.println(getName() + " es un(a) " + getSpecies() + ": " + getOnomatopoeia());
    }
}
