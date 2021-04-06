package com.example.Sports.api;

import com.example.Sports.model.Location;
import com.example.Sports.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/location")
@RestController
public class LocationController {
    private final LocationService LocationService;

    @Autowired
    public LocationController(LocationService LocationService){
        this.LocationService = LocationService;
    }

    @PostMapping
    public void addLocation(@RequestBody Location Location){
        LocationService.addLocation(Location);
    }

    @GetMapping
    public List<Location> getAllCountries(){
        return LocationService.getAllCountries();
    }

    @GetMapping(path = "{id}")
    public Location getLocationById(@PathVariable("id") UUID id){
        return LocationService.getLocationById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteLocationById(@PathVariable("id") UUID id){
        LocationService.deleteLocation(id);
    }

    @PutMapping(path = "{id}")
    public void updateLocation(@PathVariable("id") UUID id, @RequestBody Location LocationToUpdate){
        LocationService.updateLocation(id, LocationToUpdate);
    }
}
