package com.example.planets.repository;

import com.example.planets.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanetRepository extends CrudRepository<Planet, String> {

    List<Planet> findByPlanetIdentifier(String planetIdentifier);


}
