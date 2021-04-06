package com.example.Sports.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Location {
    private final UUID LocationId;
    private final String LocationName;
    private List<Sport> sports = new ArrayList<>();
    private Region region;

    public Location(UUID LocationId, String LocationName){
        this.LocationId = LocationId;
        this.LocationName = LocationName;
    }

    public UUID getLocationId(){
        return LocationId;
    }

    public String getLocationName(){
        return LocationName;
    }
}