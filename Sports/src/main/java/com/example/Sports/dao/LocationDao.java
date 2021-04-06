package com.example.Sports.dao;

import com.example.Sports.model.Location;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LocationDao {
    int insertLocation(UUID id, Location Location);
    default int insertLocation(Location Location){
        UUID id = UUID.randomUUID();
        return insertLocation(id, Location);
    }

    List<Location> selectAllCountries();

    Optional<Location> selectLocationById(UUID id);

    int deleteLocationById(UUID id);

    int updateLocationById(UUID id, Location Location);
}
