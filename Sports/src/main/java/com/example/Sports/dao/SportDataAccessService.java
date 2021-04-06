package com.example.Sports.dao;

import com.example.Sports.model.Sport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class SportDataAccessService implements SportDao{
    private final JdbcTemplate jdbcTemplate;

    public SportDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertSport(UUID id, Sport Sport) {
        return jdbcTemplate.update(
                "INSERT INTO Sport VALUES (?, ?)", Sport.getSportId(),Sport.getSportName());

    }

    @Override
    public List<Sport> selectAllCountries() {
        final String sql = "SELECT Sportid, Sportname from Sport";
        return jdbcTemplate.query(sql, ((resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("Sportid"));
            String name =  resultSet.getString("Sportname");
            return new Sport(id,name);
        }));
        //return List.of(new Sport(UUID.randomUUID(),"From Postgres DB"));

    }

    @Override
    public Optional<Sport> selectSportById(UUID id) {
        final String sql = "SELECT Sportid, Sportname from Sport WHERE Sportid = ?";
        Sport Sport = jdbcTemplate.queryForObject(sql, new Object[]{id}, ((resultSet, i) -> {
            UUID SportId = UUID.fromString(resultSet.getString("Sportid"));
            String name =  resultSet.getString("Sportname");
            return new Sport(SportId ,name);
        }));
        return Optional.ofNullable(Sport);
    }

    @Override
    public int deleteSportById(UUID id) {
        final String sql = "DELETE FROM Sport WHERE Sportid = ?";
        jdbcTemplate.update(sql,id);
        return 0;
    }

    @Override
    public int updateSportById(UUID id, Sport Sport) {
        String SQL = "update Sport set name = ? where Sportid = ?";
        jdbcTemplate.update(SQL, id);

        return 1;

    }
}
