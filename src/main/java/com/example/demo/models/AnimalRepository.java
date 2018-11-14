package com.example.demo.models;

import com.example.demo.exceptions.AnimalNotFoundException;
import com.example.demo.exceptions.AnimalNotRemovedException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
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
    public void addAnimal(String name, String species, String URL) {
        animals.add(new Animal(name, species, findUnsusedUID(), URL));
    }
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public AnimalRepository() {
        addAnimal("kotek", "kot", "https://www.catster.com/wp-content/uploads/2017/08/A-fluffy-cat-looking-funny-surprised-or-concerned.jpg");
        addAnimal("myszka", "mysz", "https://bios.net.pl/files/media/5goxs5kvwn/mysz-d.jpg");
        addAnimal("piesek", "pies", "https://i.ytimg.com/vi/SfLV8hD7zX4/maxresdefault.jpg");
    }

    public Animal getAnimalByUID(int UID) {
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
            animals.remove(getAnimalByUID(UID));
        } catch (AnimalNotFoundException e) {
            throw new AnimalNotRemovedException(UID);
        }
    }

    public ArrayList<String> getCategories(){
        ArrayList<String> categoriesTemp = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        for (Animal animal : getAnimals()) {
            if (!categoriesTemp.contains(animal.getSpecies()))
                categoriesTemp.add(animal.getSpecies());
        }
        Collections.sort(categoriesTemp);
        categories.add("wszystkie");
        for (String s : categoriesTemp) {
            categories.add(s);
        }
        return categories;
    }

    public ArrayList<Animal> getAnimalsByCategory(String categoryName){
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
