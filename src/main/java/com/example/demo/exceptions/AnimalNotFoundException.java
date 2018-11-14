package com.example.demo.exceptions;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(int UID){
        super("Animal with UID: " + UID + " was not found");
    }
    public AnimalNotFoundException(int UID, String info){
        super("Animal with UID: " + UID + " was not found\n" + info);
    }
    public AnimalNotFoundException(){
        super("Animal not found");
    }

}
