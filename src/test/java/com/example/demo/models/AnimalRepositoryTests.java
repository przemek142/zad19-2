package com.example.demo.models;

import com.example.demo.exceptions.AnimalNotFoundException;
import com.example.demo.exceptions.AnimalNotRemovedException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class AnimalRepositoryTests {

    //    addAnimal("kotek","kot");
//    addAnimal("myszka","mysz");
//    addAnimal("piesek","pies");
    AnimalRepository animals;

    @Before
    public void initTests() {
        animals = new AnimalRepository();
    }

    @Test
    public void FindTestbyUIDTest() {
        for (Animal animal : animals.getAnimals()) {
            System.out.println(animal);
        }

        Assert.assertThat(animals.getAnimalByUID(1).getName(), is("kotek"));
        Assert.assertThat(animals.getAnimalByUID(1).getSpecies(), is("kot"));
        Assert.assertThat(animals.getAnimalByUID(1).getUID(), equalTo(1));
        Assert.assertThat(animals.getAnimalByUID(1), notNullValue());
    }

    @Test
    public void AnimalNotFoundExceptionThrownTest() {
        boolean AnimalNotFoundExceptionThrown1 = false;
        boolean AnimalNotFoundExceptionThrown2 = false;

        try {
            animals.getAnimalByUID(234);
        } catch (AnimalNotFoundException e) {
            AnimalNotFoundExceptionThrown1 = true;
        }

        try {
            animals.getAnimalByUID(-23);
        } catch (AnimalNotFoundException e) {
            AnimalNotFoundExceptionThrown2 = true;
        }

        Assert.assertTrue(AnimalNotFoundExceptionThrown1);
        Assert.assertTrue(AnimalNotFoundExceptionThrown2);

    }

    @Test
    public void AnimalRemoveTest() {
        int UID = 1;
        Animal animalBefore=null, animalAfter=null;
        animalBefore = animals.getAnimalByUID(UID);
        animals.removeAnimalByUID(UID);
        try {
            animalAfter = animals.getAnimalByUID(UID);
        }catch (Exception e){

        }
        Assert.assertNotSame(animalAfter,animalBefore);

    }
    @Test
    public void AnimalNotRemovedExceptionTest() {
        boolean AnimalNotRemovedExceptionThrown = false;

        try {
            animals.removeAnimalByUID(34567);
        }catch (AnimalNotRemovedException e){
            AnimalNotRemovedExceptionThrown=true;
        }
        Assert.assertTrue(AnimalNotRemovedExceptionThrown);


    }
}
