package com.example.Sports.service;

import com.example.Sports.dao.CountryDao;
import com.example.Sports.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CountryService {
    public final CountryDao countryDao;

    @Autowired
    public CountryService(@Qualifier("postgres") CountryDao countryDao){
        this.countryDao = countryDao;
    }
    public int addCountry(Country country){
        return countryDao.insertCountry(country);
    }
    public List<Country> getAllCountries(){
        return countryDao.selectAllCountries();
    }
    public Optional<Country> getCountryById(UUID id){
        return countryDao.selectCountryById(id);
    }
    public int deleteCountry(UUID id){
        return countryDao.deleteCountryById(id);
    }
    public int updateCountry(UUID id, Country newCountry){
        return countryDao.updateCountryById(id, newCountry);
    }
}
