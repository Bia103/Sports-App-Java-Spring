package com.example.Sports.service;

import com.example.Sports.dao.PeriodDao;
import com.example.Sports.model.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PeriodService {
    public final PeriodDao PeriodDao;

    @Autowired
    public PeriodService(@Qualifier("postgres") PeriodDao PeriodDao){
        this.PeriodDao = PeriodDao;
    }
    public int addPeriod(Period Period){
        return PeriodDao.insertPeriod(Period);
    }
    public List<Period> getAllCountries(){
        return PeriodDao.selectAllCountries();
    }
    public Optional<Period> getPeriodById(UUID id){
        return PeriodDao.selectPeriodById(id);
    }
    public int deletePeriod(UUID id){
        return PeriodDao.deletePeriodById(id);
    }
    public int updatePeriod(UUID id, Period newPeriod){
        return PeriodDao.updatePeriodById(id, newPeriod);
    }
}
