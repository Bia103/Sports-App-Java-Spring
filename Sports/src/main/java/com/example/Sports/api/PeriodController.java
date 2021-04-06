package com.example.Sports.api;

import com.example.Sports.model.Period;
import com.example.Sports.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/period")
@RestController
public class PeriodController {
    private final com.example.Sports.service.PeriodService PeriodService;

    @Autowired
    public PeriodController(PeriodService PeriodService){
        this.PeriodService = PeriodService;
    }

    @PostMapping
    public void addPeriod(@RequestBody Period Period){
        PeriodService.addPeriod(Period);
    }

    @GetMapping
    public List<Period> getAllCountries(){
        return PeriodService.getAllCountries();
    }

    @GetMapping(path = "{id}")
    public Period getPeriodById(@PathVariable("id") UUID id){
        return PeriodService.getPeriodById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deletePeriodById(@PathVariable("id") UUID id){
        PeriodService.deletePeriod(id);
    }

    @PutMapping(path = "{id}")
    public void updatePeriod(@PathVariable("id") UUID id, @RequestBody Period PeriodToUpdate){
        PeriodService.updatePeriod(id, PeriodToUpdate);
    }
}
