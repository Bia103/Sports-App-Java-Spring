package com.example.Sports.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Country {
    private final UUID CountryId;
    
    private final String CountryName;


    private List<Region> Regions = new ArrayList<>();

    public Country(@JsonProperty("id") UUID CountryId,
                   @JsonProperty("country") String CountryName){
        this.CountryId = CountryId;
        this.CountryName = CountryName;
    }

    public  UUID getCountryId(){
        return CountryId;
    }

    public String getCountryName() {
        return CountryName;
    }


}