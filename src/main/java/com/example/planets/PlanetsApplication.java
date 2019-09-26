package com.example.planets;

import com.example.planets.model.Planet;
import com.example.planets.repository.PlanetRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@EnableJpaRepositories("com.example.planets.repository")
@EntityScan("com.example.planets.model")
@SpringBootApplication
public class PlanetsApplication {

    private static String planetURL = "https://gist.githubusercontent.com/joelbirchler/66cf8045fcbb6515557347c05d789b4a/raw/9a196385b44d4288431eef74896c0512bad3defe/exoplanets";

    @Autowired
    PlanetRepository planetRepository;

    public static void main(String[] args) {
        SpringApplication.run(PlanetsApplication.class, args);
    }

    @PostConstruct
    private void init() throws Exception {
        System.out.println("Reading planets data from URL");
        String jsonPlanetArray = "";
        try (Scanner scanner = new Scanner(new URL(planetURL).openStream(),
                StandardCharsets.UTF_8.toString()))
        {
            scanner.useDelimiter("\\A");
            if ( scanner.hasNext() ) {
                jsonPlanetArray = scanner.next();
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<Planet> planets = Arrays.asList(mapper.readValue(jsonPlanetArray, Planet[].class));

        System.out.println("Planets parsed from JSON: " + planets.size());

        System.out.println("Populating in-memory database for use by application.");
        for ( Planet p : planets ) {
            planetRepository.save(p);
        }

        // Sanity check logging on startup
        System.out.println("Planet with hottest star: \n" + planetRepository.findPlanetWithHottestStar());
        System.out.println("Orphan planet count: " + planetRepository.findOrphanPlanets().size());

    }

}
