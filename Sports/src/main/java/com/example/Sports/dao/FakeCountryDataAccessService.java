package com.example.Sports.dao;

import com.example.Sports.model.Country;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Repository("fakeDao")
public class FakeCountryDataAccessService implements CountryDao{

    private static List<Country> DBC = new ArrayList<>();
    @Override
    public int insertCountry(UUID id, Country country) {
        DBC.add(new Country(id, country.getCountryName()));
        return 1;
    }

    @Override
    public List<Country> selectAllCountries(){
        return DBC;
    }

    @Override
    public Optional<Country> selectCountryById(UUID id) {
        return DBC.stream()
                .filter(country -> country.getCountryId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteCountryById(UUID id) {
        Optional<Country> maybeCountry = selectCountryById(id);
        if(maybeCountry.isEmpty())
            return 0;
        DBC.remove(maybeCountry.get());
        return 1;
    }

    @Override
    public int updateCountryById(UUID id, Country update) {
        return selectCountryById(id)
                .map(c ->{
                    int indexOfCountryToUpdate = DBC.indexOf(c);
                    if(indexOfCountryToUpdate >= 0) {
                        DBC.set(indexOfCountryToUpdate, new Country(id, update.getCountryName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);

    }
}
