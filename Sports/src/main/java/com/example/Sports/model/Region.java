package com.example.Sports.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Region {
    private final UUID RegionId;
    private final String RegionName;
    private Country country;
    private List<Region> Location = new ArrayList<>();

    public Region(UUID RegionId, String RegionName){
        this.RegionId = RegionId;
        this.RegionName = RegionName;
    }

    public UUID getRegionId(){
        return RegionId;
    }

    public String getRegionName(){
        return RegionName;
    }
}