package com.example.Sports.dao;

import com.example.Sports.model.Period;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PeriodDao {
    int insertPeriod(UUID id, Period Period);
    default int insertPeriod(Period Period){
        UUID id = UUID.randomUUID();
        return insertPeriod(id, Period);
    }

    List<Period> selectAllCountries();

    Optional<Period> selectPeriodById(UUID id);

    int deletePeriodById(UUID id);

    int updatePeriodById(UUID id, Period Period);
}
