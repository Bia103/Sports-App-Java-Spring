package com.example.Sports.service;

import com.example.Sports.dao.RegionDao;
import com.example.Sports.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RegionService {
    public final RegionDao RegionDao;

    @Autowired
    public RegionService(@Qualifier("postgres") RegionDao RegionDao){
        this.RegionDao = RegionDao;
    }
    public int addRegion(Region Region){
        return RegionDao.insertRegion(Region);
    }
    public List<Region> getAllCountries(){
        return RegionDao.selectAllCountries();
    }
    public Optional<Region> getRegionById(UUID id){
        return RegionDao.selectRegionById(id);
    }
    public int deleteRegion(UUID id){
        return RegionDao.deleteRegionById(id);
    }
    public int updateRegion(UUID id, Region newRegion){
        return RegionDao.updateRegionById(id, newRegion);
    }
}
