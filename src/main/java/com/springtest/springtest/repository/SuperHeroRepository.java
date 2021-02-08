package com.springtest.springtest.repository;

import com.springtest.springtest.entity.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, String> {
    Optional<Object> findById(SuperHero id);
}
