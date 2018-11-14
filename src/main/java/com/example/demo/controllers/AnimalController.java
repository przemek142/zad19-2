package com.example.demo.controllers;

import com.example.demo.models.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class AnimalController {

    AnimalRepository animalRepository;

    @Autowired
    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/animals")
    public String rootController(Model model) {

        model.addAttribute("animals", animalRepository.getAnimals());

        return "animals";
    }

}
