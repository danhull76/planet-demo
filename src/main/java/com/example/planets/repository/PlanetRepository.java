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

    @Query(value = "SELECT p FROM Planet p WHERE p.radiusJpt < 1 AND p.discoveryYear IS NOT NULL ORDER BY p.discoveryYear")
    List<Planet> findSmallPlanets();

    @Query(value = "SELECT p FROM Planet p WHERE p.radiusJpt >= 1 AND p.radiusJpt < 2  AND p.discoveryYear IS NOT NULL ORDER BY p.discoveryYear")
    List<Planet> findMediumPlanets();

    @Query(value = "SELECT p FROM Planet p WHERE p.radiusJpt >= 2 AND p.discoveryYear IS NOT NULL ORDER BY p.discoveryYear")
    List<Planet> findLargePlanets();

}
