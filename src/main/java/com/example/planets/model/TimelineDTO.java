package com.example.planets.model;

import lombok.Data;

@Data
public class TimelineDTO implements Comparable<TimelineDTO>{

    public TimelineDTO( int y, int l, int m, int s ) {
        this.year = y;
        this.large = l;
        this.medium = m;
        this.small = s;
    }

    public TimelineDTO( int y ) {
        this.year = y;
        this.large = 0;
        this.medium = 0;
        this.small = 0;
    }

    public Integer year;

    public Integer large;

    public Integer medium;

    public Integer small;

    public int compareTo( TimelineDTO t ) {
        return this.year.compareTo(t.year);
    }

}
