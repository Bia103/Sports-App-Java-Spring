package com.example.Sports.dao;

import com.example.Sports.model.Location;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class LocationDataAccessService implements LocationDao{
    private final JdbcTemplate jdbcTemplate;

    public LocationDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertLocation(UUID id, Location Location) {
        return jdbcTemplate.update(
                "INSERT INTO Location VALUES (?, ?)", Location.getLocationId(),Location.getLocationName());

    }

    @Override
    public List<Location> selectAllCountries() {
        final String sql = "SELECT Locationid, Locationname from Location";
        return jdbcTemplate.query(sql, ((resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("Locationid"));
            String name =  resultSet.getString("Locationname");
            return new Location(id,name);
        }));
        //return List.of(new Location(UUID.randomUUID(),"From Postgres DB"));

    }

    @Override
    public Optional<Location> selectLocationById(UUID id) {
        final String sql = "SELECT Locationid, Locationname from Location WHERE Locationid = ?";
        Location Location = jdbcTemplate.queryForObject(sql, new Object[]{id}, ((resultSet, i) -> {
            UUID LocationId = UUID.fromString(resultSet.getString("Locationid"));
            String name =  resultSet.getString("Locationname");
            return new Location(LocationId ,name);
        }));
        return Optional.ofNullable(Location);
    }

    @Override
    public int deleteLocationById(UUID id) {
        final String sql = "DELETE FROM Location WHERE Locationid = ?";
        jdbcTemplate.update(sql,id);
        return 0;
    }

    @Override
    public int updateLocationById(UUID id, Location Location) {
        String SQL = "update Location set name = ? where Locationid = ?";
        jdbcTemplate.update(SQL, id);

        return 1;

    }
    
}
