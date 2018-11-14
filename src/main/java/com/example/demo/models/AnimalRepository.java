package com.example.demo.models;

import com.example.demo.exceptions.AnimalNotFoundException;
import com.example.demo.exceptions.AnimalNotRemovedException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalRepository {

    private List<Animal> animals = new ArrayList<>();

    public AnimalRepository(List<Animal> animals) {
        this.animals = animals;
    }

    private int findUnsusedUID() {
        int lastUID = 0;
        for (Animal animal : animals) {
            if (animal.getUID() > lastUID)
                lastUID = animal.getUID();
        }
        return lastUID + 1;
    }

    public void addAnimal(String name, String species) {
        animals.add(new Animal(name, species, findUnsusedUID()));
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public AnimalRepository() {
        addAnimal("kotek", "kot");
        addAnimal("myszka", "mysz");
        addAnimal("piesek", "pies");
    }

    public Animal findAnimalByUID(int UID) {
        Animal returnAnimal = null;
        for (Animal animal : getAnimals()) {
            if (animal.getUID() == UID)
                returnAnimal = animal;
        }
        if (returnAnimal == null)
            throw new AnimalNotFoundException(UID);

        return returnAnimal;
    }


    public void removeAnimalByUID(int UID) {
        try {
            animals.remove(findAnimalByUID(UID));
        } catch (AnimalNotFoundException e) {
            throw new AnimalNotRemovedException(UID);
        }
    }


    public List<Animal> getAnimals() {
        return animals;
    }
}
