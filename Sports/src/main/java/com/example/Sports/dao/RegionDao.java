package com.example.Sports.dao;

import com.example.Sports.model.Region;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RegionDao {
    int insertRegion(UUID id, Region Region);
    default int insertRegion(Region Region){
        UUID id = UUID.randomUUID();
        return insertRegion(id, Region);
    }

    List<Region> selectAllCountries();

    Optional<Region> selectRegionById(UUID id);

    int deleteRegionById(UUID id);

    int updateRegionById(UUID id, Region Region);
}
