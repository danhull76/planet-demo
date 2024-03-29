package com.example.planets;

import com.example.planets.model.Planet;
import com.example.planets.model.TimelineDTO;
import com.example.planets.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlanetController {

    @Autowired
    PlanetService planetService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", "Hello (exo) World(s)!");
        return "home";
    }

    @GetMapping("/orphans")
    public String orphans(Model model) {
        model.addAttribute("orphanCount", planetService.getOrphanPlanetCount());

        return "orphans";
    }

    @GetMapping("/hottest")
    public String hottest(Model model) {
        Planet p = planetService.getPlanetWithHottestStar();

        model.addAttribute("planetName", p.getPlanetIdentifier());
        model.addAttribute("starTemp", p.getHostStarTempK());

        return "hottest";
    }

    @GetMapping("/timeline")
    public String timeline(Model model) {
        List<TimelineDTO> timeline = planetService.getTimeline();
        model.addAttribute("timeline", timeline );

        return "timeline";
    }

}