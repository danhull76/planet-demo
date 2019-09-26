package com.example.planets.repository;

import com.example.planets.model.Planet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanetRepository extends CrudRepository<Planet, String> {

    List<Planet> findByPlanetIdentifier(String planetIdentifier);

    @Query(value = "SELECT * FROM PLANET p WHERE p.HOST_STAR_TEMPK = ( SELECT MAX(HOST_STAR_TEMPK) FROM PLANET )",
            nativeQuery = true)
    Planet findPlanetWithHottestStar();

    @Query(value = "SELECT * FROM PLANET p WHERE p.TYPE = 3",
            nativeQuery = true)
    List<Planet> findOrphanPlanets();

    /* select COUNT(*), DISCOVERY_YEAR from PLANET GROUP BY DISCOVERY_YEAR */

    /* TODO: make Timeline DTO and map results directly with JPQL */

}
