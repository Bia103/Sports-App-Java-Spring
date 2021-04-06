package com.example.Sports.service;

import com.example.Sports.dao.SportDao;
import com.example.Sports.model.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SportService {
    public final SportDao SportDao;

    @Autowired
    public SportService(@Qualifier("postgres") SportDao SportDao){
        this.SportDao = SportDao;
    }
    public int addSport(Sport Sport){
        return SportDao.insertSport(Sport);
    }
    public List<Sport> getAllCountries(){
        return SportDao.selectAllCountries();
    }
    public Optional<Sport> getSportById(UUID id){
        return SportDao.selectSportById(id);
    }
    public int deleteSport(UUID id){
        return SportDao.deleteSportById(id);
    }
    public int updateSport(UUID id, Sport newSport){
        return SportDao.updateSportById(id, newSport);
    }
}
