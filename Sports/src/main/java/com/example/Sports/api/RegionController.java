package com.example.Sports.api;

import com.example.Sports.model.Region;
import com.example.Sports.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/region")
@RestController
public class RegionController {

    private final RegionService RegionService;

    @Autowired
    public RegionController(RegionService RegionService){
        this.RegionService = RegionService;
    }

    @PostMapping
    public void addRegion(@RequestBody Region Region){
        RegionService.addRegion(Region);
    }

    @GetMapping
    public List<Region> getAllCountries(){
        return RegionService.getAllCountries();
    }

    @GetMapping(path = "{id}")
    public Region getRegionById(@PathVariable("id") UUID id){
        return RegionService.getRegionById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteRegionById(@PathVariable("id") UUID id){
        RegionService.deleteRegion(id);
    }

    @PutMapping(path = "{id}")
    public void updateRegion(@PathVariable("id") UUID id, @RequestBody Region RegionToUpdate){
        RegionService.updateRegion(id, RegionToUpdate);
    }
}
