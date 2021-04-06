package com.example.Sports.model;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Sport {
    private final UUID SportId;
    private final String SportName;
    private List<Period> periods = new ArrayList<>();
    private Location location;


    public Sport(UUID SportId, String SportName){
        this.SportId = SportId;
        this.SportName = SportName;
    }

    public UUID getSportId(){
        return SportId;
    }

    public String getSportName(){
        return SportName;
    }
}