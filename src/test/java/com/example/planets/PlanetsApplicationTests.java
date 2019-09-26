package com.example.planets;

import com.example.planets.model.Planet;
import com.example.planets.model.TimelineDTO;
import com.example.planets.repository.PlanetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetsApplicationTests {

    @Autowired
    PlanetService planetService;

//    @Test
//    public void contextLoads() {
//    }

    @Test
    public void testOrphanCount() {
        Integer count = planetService.getOrphanPlanetCount();

        assertEquals((Integer) 2, count);
    }

    @Test
    public void testHottest() {
        Planet p = planetService.getPlanetWithHottestStar();
        assertEquals("V391 Peg b", p.getPlanetIdentifier());
    }

    @Test
    public void testTimeline() {
        List<TimelineDTO> timeline = planetService.getTimeline();

        // Check for expected number of entries in timeline results
        assertEquals(19 , timeline.size());

        // spot-check 2004
        TimelineDTO tl2004 = new TimelineDTO();
        for ( int i=0; i<timeline.size(); i++ ) {
            if ( timeline.get(i).getYear().equals(2004) ) {
                tl2004 = timeline.get(i);
            }
        }

        assertEquals((Integer) 2, tl2004.getSmall());
        assertEquals((Integer) 5, tl2004.getMedium());
        assertEquals((Integer) 0, tl2004.getLarge());
    }

}
