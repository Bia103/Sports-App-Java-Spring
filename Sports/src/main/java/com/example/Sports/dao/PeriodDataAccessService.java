package com.example.Sports.dao;

import com.example.Sports.model.Period;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PeriodDataAccessService implements PeriodDao{
    private final JdbcTemplate jdbcTemplate;

    public PeriodDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPeriod(UUID id, Period Period) {
        return jdbcTemplate.update(
                "INSERT INTO Period VALUES (?, ?, ?)", Period.getPeriodId(),Period.getStartDate(), Period.getEndDate());

    }

    @Override
    public List<Period> selectAllCountries() {
    return null;

    }

    @Override
    public Optional<Period> selectPeriodById(UUID id) {

        return null;
    }

    @Override
    public int deletePeriodById(UUID id) {
        final String sql = "DELETE FROM Period WHERE Periodid = ?";
        jdbcTemplate.update(sql,id);
        return 0;
    }

    @Override
    public int updatePeriodById(UUID id, Period Period) {
        String SQL = "update Period set name = ? where Periodid = ?";
        jdbcTemplate.update(SQL, id);

        return 1;

    }
}
