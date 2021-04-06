package com.example.Sports.dao;

import com.example.Sports.model.Sport;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SportDao {
    int insertSport(UUID id, Sport Sport);
    default int insertSport(Sport Sport){
        UUID id = UUID.randomUUID();
        return insertSport(id, Sport);
    }

    List<Sport> selectAllCountries();

    Optional<Sport> selectSportById(UUID id);

    int deleteSportById(UUID id);

    int updateSportById(UUID id, Sport Sport);
}
