package com.example.demo.controllers;

import com.example.demo.models.Animal;
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
    public String allAnimalsController(Model model, @RequestParam(value = "cat", required = false) String cat) {
        if ("wszystkie".equals(cat) || cat == null)
            model.addAttribute("animals", animalRepository.getAnimals());
        else
            model.addAttribute("animals", animalRepository.getAnimalsByCategory(cat));

        model.addAttribute("cat", animalRepository.getCategories());
        return "allAnimals";
    }

    @GetMapping("/dodaj")
    public String addAnimalController(Model model) {
        model.addAttribute("animals", animalRepository.getAnimals());
        model.addAttribute("cat", animalRepository.getCategories());
        model.addAttribute("newAnimal", new Animal());

        return "addAnimal";
    }

    @GetMapping("/killKillKill")
    public String killBeastie(Model model, @RequestParam Integer UID) {
        model.addAttribute("animals", animalRepository.getAnimals());
        model.addAttribute("cat", animalRepository.getCategories());
        animalRepository.removeAnimalByUID(UID);
        return "redirect:wszystkieZwierzaki";
    }

    @GetMapping("/killLovelyCreature")
    public String killSingleBeast(Model model) {
        model.addAttribute("animals", animalRepository.getAnimals());
        model.addAttribute("cat", animalRepository.getCategories());
        return "killTheBeast";
    }

    @GetMapping("/singleAnimal")
    public String showSinleAnimalController(Model model, @RequestParam Integer UID) {
        model.addAttribute("animal", animalRepository.getAnimalByUID(UID));
        return "singleAnimal";
    }

    @PostMapping("/saveAnimal")
    public String saveAnimal(Animal animal) {
        animalRepository.addAnimal(animal);
        return "redirect:wszystkieZwierzaki";
    }
}
