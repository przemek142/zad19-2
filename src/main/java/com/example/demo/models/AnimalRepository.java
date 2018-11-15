package com.example.demo.models;

import com.example.demo.exceptions.AnimalNotFoundException;
import com.example.demo.exceptions.AnimalNotRemovedException;
import org.springframework.stereotype.Repository;

import java.util.*;

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

    public void addAnimal(String name, String species, String description) {
        animals.add(new Animal(name, species, findUnsusedUID(), description));
    }

    public void addAnimal(String name, String species, String URL, String description) {
        animals.add(new Animal(name, species, findUnsusedUID(), URL, description));
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public AnimalRepository() {
        addAnimal("kotek", "kot", "https://www.catster.com/wp-content/uploads/2017/08/A-fluffy-cat-looking-funny-surprised-or-concerned.jpg", "opis");
        addAnimal("myszka", "mysz", "https://bios.net.pl/files/media/5goxs5kvwn/mysz-d.jpg", "opis");
        addAnimal("piesek", "pies", "https://i.ytimg.com/vi/SfLV8hD7zX4/maxresdefault.jpg", "opis");
    }

    public Animal getAnimalByUID(int UID) {
        for (Animal animal : getAnimals()) {
            if (animal.getUID() == UID)
                return animal;
        }
        throw new AnimalNotFoundException(UID);
    }


    public void removeAnimalByUID(int UID) {
        try {
            animals.remove(getAnimalByUID(UID));
        } catch (AnimalNotFoundException e) {
            throw new AnimalNotRemovedException(UID);
        }
    }

    public ArrayList<String> getCategories() {
        ArrayList<String> list = new ArrayList<>(); // żeby "wszysktie" było pierwsze na liście
        Set<String> setTemp = new TreeSet<>(); //do sortowania nazw

        for (Animal animal : getAnimals()) {
           setTemp.add(animal.getSpecies());
        }
        list.add("wszystkie");
        for (String s : setTemp) {
            list.add(s);
        }
        return list;
    }

    public ArrayList<Animal> getAnimalsByCategory(String categoryName) {
        ArrayList<Animal> listOfAnimals = new ArrayList<>();
        for (Animal animal : getAnimals()) {
            if (animal.getSpecies().compareTo(categoryName) == 0)
                listOfAnimals.add(animal);
        }
        return listOfAnimals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
