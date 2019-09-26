package com.example.planets;

import com.example.planets.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlanetController {

    @Autowired
    PlanetRepository planetRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", "Hello (exo) World(s)!");
        return "home";
    }

    @GetMapping("/orphans")
    public String orphans(Model model) {
        model.addAttribute("orphanCount", planetRepository.findOrphanPlanets().size());

        return "orphans";
    }

    @GetMapping("/hottest")
    public String hottest(Model model) {
        model.addAttribute("planetName", planetRepository.findPlanetWithHottestStar().getPlanetIdentifier());
        model.addAttribute("starTemp", planetRepository.findPlanetWithHottestStar().getHostStarTempK());

        return "hottest";
    }

}