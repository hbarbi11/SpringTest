package com.springtest.springtest.controller;

import com.springtest.springtest.entity.SuperHero;
import com.springtest.springtest.exception.ValidationException;
import com.springtest.springtest.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/super-hero")
public class SuperHeroController {

    private final SuperHeroService superHeroService;

    @Autowired
    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @PostMapping("/save")
    public SuperHero save (@RequestBody SuperHero superHero) {
        return superHeroService.createSuperHero(superHero);
    }

    @GetMapping("/superhero/{id}")
    public SuperHero findById (@PathVariable("id") String id) {
        try {
            return superHeroService.findSuperHeroById(id);
        } catch (ValidationException e) {
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }

    @GetMapping("/findallsuperhero")
    public List<SuperHero> findAllSuperhero () {
        return superHeroService.findAllSuperHero();
    }


}
