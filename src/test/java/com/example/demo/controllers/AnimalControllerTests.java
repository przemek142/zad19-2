package com.example.demo.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnimalControllerTests {

    @Autowired
    private AnimalController controller;

    @Test
    public void AnimalControllerTest()  {
        Assert.assertNotSame(controller,null);
    }

}
