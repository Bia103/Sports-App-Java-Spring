package com.example.Sports.dao;

import com.example.Sports.model.Region;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class RegionDataAccessService implements RegionDao{
    private final JdbcTemplate jdbcTemplate;

    public RegionDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertRegion(UUID id, Region Region) {
        return jdbcTemplate.update(
                "INSERT INTO Region VALUES (?, ?)", Region.getRegionId(),Region.getRegionName());

    }

    @Override
    public List<Region> selectAllCountries() {
        final String sql = "SELECT Regionid, Regionname from Region";
        return jdbcTemplate.query(sql, ((resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("Regionid"));
            String name =  resultSet.getString("Regionname");
            return new Region(id,name);
        }));
        //return List.of(new Region(UUID.randomUUID(),"From Postgres DB"));

    }

    @Override
    public Optional<Region> selectRegionById(UUID id) {
        final String sql = "SELECT Regionid, Regionname from Region WHERE Regionid = ?";
        Region Region = jdbcTemplate.queryForObject(sql, new Object[]{id}, ((resultSet, i) -> {
            UUID RegionId = UUID.fromString(resultSet.getString("Regionid"));
            String name =  resultSet.getString("Regionname");
            return new Region(RegionId ,name);
        }));
        return Optional.ofNullable(Region);
    }

    @Override
    public int deleteRegionById(UUID id) {
        final String sql = "DELETE FROM Region WHERE Regionid = ?";
        jdbcTemplate.update(sql,id);
        return 0;
    }

    @Override
    public int updateRegionById(UUID id, Region Region) {
        String SQL = "update Region set name = ? where Regionid = ?";
        jdbcTemplate.update(SQL, id);

        return 1;

    }
}
