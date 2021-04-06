package com.example.Sports.api;

import com.example.Sports.model.Sport;
import com.example.Sports.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/Sport")
@RestController
public class SportController {
    private final com.example.Sports.service.SportService SportService;

    @Autowired
    public SportController(SportService SportService){
        this.SportService = SportService;
    }

    @PostMapping
    public void addSport(@RequestBody Sport Sport){
        SportService.addSport(Sport);
    }

    @GetMapping
    public List<Sport> getAllCountries(){
        return SportService.getAllCountries();
    }

    @GetMapping(path = "{id}")
    public Sport getSportById(@PathVariable("id") UUID id){
        return SportService.getSportById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteSportById(@PathVariable("id") UUID id){
        SportService.deleteSport(id);
    }

    @PutMapping(path = "{id}")
    public void updateSport(@PathVariable("id") UUID id, @RequestBody Sport SportToUpdate){
        SportService.updateSport(id, SportToUpdate);
    }
}
