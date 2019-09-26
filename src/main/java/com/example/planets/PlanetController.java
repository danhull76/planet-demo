package com.example.planets;

import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlanetController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", "Hello (exo) World(s)!");
        return "home";
    }

    @GetMapping("/orphans")
    public String orphans() {
        return "";
    }

}