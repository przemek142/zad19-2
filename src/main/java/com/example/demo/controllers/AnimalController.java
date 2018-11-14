package com.example.demo.controllers;

import com.example.demo.models.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class AnimalController {

    AnimalRepository animalRepository;

    @Autowired
    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/")
    public String rootController() {
        return "redirect:/wszystkieZwierzaki";
    }

    @GetMapping("/wszystkieZwierzaki")
    public String allAnimalsController(Model model, @RequestParam(value = "cat", required = false, defaultValue = "null") String cat) {
        if ("wszystkie".compareTo(cat) == 0 || "null".compareTo(cat) == 0)
            model.addAttribute("animals", animalRepository.getAnimals());
        else
            model.addAttribute("animals",animalRepository.getAnimalsByCategory(cat));

        model.addAttribute("cat", animalRepository.getCategories());
        return "allAnimals";
    }

    @GetMapping("/dodaj")
    public String addAnimalController(Model model) {
        model.addAttribute("animals", animalRepository.getAnimals());
        return "addAnimal";
    }

    @GetMapping("/singleAnimal")
    public String showSinleAnimalController(Model model, @RequestParam Integer UID) {
        model.addAttribute("animal", animalRepository.getAnimalByUID(UID));
        return "singleAnimal";
    }
}
