package com.example.Sports.service;

import com.example.Sports.dao.LocationDao;
import com.example.Sports.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LocationService {
    public final LocationDao LocationDao;

    @Autowired
    public LocationService(@Qualifier("postgres") LocationDao LocationDao){
        this.LocationDao = LocationDao;
    }
    public int addLocation(Location Location){
        return LocationDao.insertLocation(Location);
    }
    public List<Location> getAllCountries(){
        return LocationDao.selectAllCountries();
    }
    public Optional<Location> getLocationById(UUID id){
        return LocationDao.selectLocationById(id);
    }
    public int deleteLocation(UUID id){
        return LocationDao.deleteLocationById(id);
    }
    public int updateLocation(UUID id, Location newLocation){
        return LocationDao.updateLocationById(id, newLocation);
    }
}
