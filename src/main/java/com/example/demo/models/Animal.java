package com.example.demo.models;

public class Animal {
    private String name;
    private String species;
    private int UID;

    public int getUID() {
        return UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }


    public Animal(String name, String species, int UID) {
        this.name = name;
        this.species = species;
        this.UID = UID;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", UID=" + UID +
                '}';
    }
}
