package com.springtest.springtest.service;

import com.springtest.springtest.entity.SuperHero;
import com.springtest.springtest.exception.ValidationException;
import com.springtest.springtest.repository.SuperHeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperHeroService {

    private final SuperHeroRepository superHeroRepository;

    @Autowired
    public SuperHeroService(SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
    }

    public SuperHero createSuperHero (SuperHero superHero) {
        return superHeroRepository.save(superHero);
    }

    public List<SuperHero> findAllSuperHero () {
        return superHeroRepository.findAll();
    }

    public SuperHero findSuperHeroById (String id) throws ValidationException {
        return superHeroRepository.findById(id).orElseThrow(() -> new ValidationException("No such an element with this ID"))
    }

    public SuperHero modifySuperHero (SuperHero superHero) throws ValidationException {
        SuperHero superHeroModified = findSuperHeroById(superHero.getId());

        return superHeroRepository.save(superHeroModified);
    }

}
