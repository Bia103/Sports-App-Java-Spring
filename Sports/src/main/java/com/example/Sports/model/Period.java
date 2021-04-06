package com.example.Sports.model;

import javax.xml.crypto.Data;
import java.util.UUID;

public class Period {
    private final UUID PeriodId;
    private final Data StartDate;
    private final Data EndDate;
    Sport sport;

    public Period(UUID PeriodId, Data StartDate, Data EndDate){
        this.PeriodId = PeriodId;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
    }

    public UUID getPeriodId(){
        return PeriodId;
    }

    public Data getStartDate(){
        return StartDate;
    }
    public Data getEndDate(){
        return StartDate;
    }
}