package com.example.demo.models;

public class Animal {
    private String name;
    private String species;
    private int UID;
    private String URL = "https://www.freeiconspng.com/uploads/no-image-icon-4.png";
    private String description = " ";

    public String getDescription() {
        return description;
    }

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

    public Animal() {
    }

    public Animal(String name, String species, int UID, String description) {
        this.name = name;
        this.species = species;
        this.UID = UID;
        this.description = description;
    }

    public Animal(String name, String species, int UID, String URL, String description) {
        this.name = name;
        this.species = species;
        this.UID = UID;
        this.URL = URL;
        this.description = description;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getURL() {
        return URL;
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
