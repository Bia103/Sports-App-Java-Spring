package com.example.Sports.api;

import com.example.Sports.model.Country;
import com.example.Sports.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/country")
@RestController
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @PostMapping
    public void addCountry(@RequestBody Country country){
        countryService.addCountry(country);
    }

    @GetMapping
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping(path = "{id}")
    public Country getCountryById(@PathVariable("id") UUID id){
        return countryService.getCountryById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteCountryById(@PathVariable("id") UUID id){
        countryService.deleteCountry(id);
    }

    @PutMapping(path = "{id}")
    public void updateCountry(@PathVariable("id") UUID id, @RequestBody Country countryToUpdate){
        countryService.updateCountry(id, countryToUpdate);
    }
}
