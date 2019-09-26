package com.example.planets;

import com.example.planets.model.Planet;
import com.example.planets.model.TimelineDTO;
import com.example.planets.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlanetService {

    @Autowired
    PlanetRepository planetRepository;

    public List<TimelineDTO> getTimeline() {
        Map<Integer, TimelineDTO> timelineMap = new HashMap<>();

        List<Planet> planets = planetRepository.findSmallPlanets();
        for ( Planet p : planets ) {
            if ( timelineMap.get(p.getDiscoveryYear()) == null ) {
                timelineMap.put(p.getDiscoveryYear(), new TimelineDTO(p.getDiscoveryYear(),0,0,1));
            } else {
                timelineMap.get(p.getDiscoveryYear()).setSmall( timelineMap.get(p.getDiscoveryYear()).getSmall() + 1 );
            }
        }

        planets = planetRepository.findMediumPlanets();
        for ( Planet p : planets ) {
            if ( timelineMap.get(p.getDiscoveryYear()) == null ) {
                timelineMap.put(p.getDiscoveryYear(), new TimelineDTO(p.getDiscoveryYear(),0,1, 0));
            } else {
                timelineMap.get(p.getDiscoveryYear()).setMedium( timelineMap.get(p.getDiscoveryYear()).getMedium() + 1 );
            }
        }

        planets = planetRepository.findLargePlanets();
        for ( Planet p : planets ) {
            if ( timelineMap.get(p.getDiscoveryYear()) == null ) {
                timelineMap.put(p.getDiscoveryYear(), new TimelineDTO(p.getDiscoveryYear(),1,0, 0));
            } else {
                timelineMap.get(p.getDiscoveryYear()).setLarge( timelineMap.get(p.getDiscoveryYear()).getLarge() + 1 );
            }
        }


        ArrayList result = new ArrayList(timelineMap.values());
        Collections.sort(result);

        return ( result );

    }


}
