package com.example.Sports.dao;

import com.example.Sports.model.Country;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class CountryDataAccessService implements CountryDao{

    private final JdbcTemplate jdbcTemplate;

    public CountryDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCountry(UUID id, Country country) {
        return jdbcTemplate.update(
                "INSERT INTO country VALUES (?, ?)", country.getCountryId(),country.getCountryName());

    }

    @Override
    public List<Country> selectAllCountries() {
        final String sql = "SELECT countryid, countryname from country";
        return jdbcTemplate.query(sql, ((resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("countryid"));
            String name =  resultSet.getString("countryname");
            return new Country(id,name);
        }));
        //return List.of(new Country(UUID.randomUUID(),"From Postgres DB"));

    }

    @Override
    public Optional<Country> selectCountryById(UUID id) {
        final String sql = "SELECT countryid, countryname from country WHERE countryid = ?";
        Country country = jdbcTemplate.queryForObject(sql, new Object[]{id}, ((resultSet, i) -> {
            UUID countryId = UUID.fromString(resultSet.getString("countryid"));
            String name =  resultSet.getString("countryname");
            return new Country(countryId ,name);
        }));
        return Optional.ofNullable(country);
    }

    @Override
    public int deleteCountryById(UUID id) {
        final String sql = "DELETE FROM country WHERE countryid = ?";
        jdbcTemplate.update(sql,id);
        return 0;
    }

    @Override
    public int updateCountryById(UUID id, Country country) {
        String SQL = "update country set name = ? where countryid = ?";
        jdbcTemplate.update(SQL, id);

        return 1;

    }
}
