package com.example.demo.exceptions;

public class AnimalNotRemovedException extends AnimalNotFoundException {
    public AnimalNotRemovedException(int UID) {
        super(UID,"Animal was not removed");
    }
}
