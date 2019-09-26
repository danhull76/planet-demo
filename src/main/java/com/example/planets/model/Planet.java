package com.example.planets.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Planet implements Comparable<Planet>{
    /*
    JSON Data format for Planet

    "PlanetIdentifier": "KOI-1843.03",
    "TypeFlag": 0,
    "PlanetaryMassJpt": 0.0014,
    "RadiusJpt": 0.054,
    "PeriodDays": 0.1768913,
    "SemiMajorAxisAU": 0.0048,
    "Eccentricity": "",
    "PeriastronDeg": "",
    "LongitudeDeg": "",
    "AscendingNodeDeg": "",
    "InclinationDeg": 72,
    "SurfaceTempK": "",
    "AgeGyr": "",
    "DiscoveryMethod": "transit",
    "DiscoveryYear": 2012,
    "LastUpdated": "13/07/15",
    "RightAscension": "19 00 03.14",
    "Declination": "+40 13 14.7",
    "DistFromSunParsec": "",
    "HostStarMassSlrMass": 0.46,
    "HostStarRadiusSlrRad": 0.45,
    "HostStarMetallicity": 0,
    "HostStarTempK": 3584,
    "HostStarAgeGyr": ""
     */


    // Jupiter radius: 69911000 m



    @Id
    @JsonProperty("PlanetIdentifier")
    private String planetIdentifier;

    @JsonProperty("HostStarTempK")
    private Double hostStarTempK;

    @JsonProperty("RadiusJpt")
    private Double radiusJpt;

    @JsonProperty("DiscoveryYear")
    private Integer discoveryYear;

    /* TypeFlag : 0=no known stellar binary companion; 1=P-type binary (circumbinary); 2=S-type binary; 3=orphan planet (no star) */
    @JsonProperty("TypeFlag")
    private Integer type;

    public int compareTo( Planet p ) {
        return this.discoveryYear.compareTo(p.discoveryYear);
    }

}
