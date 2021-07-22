package com.example.SteDziPanki.repository;


import com.example.SteDziPanki.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {


    Trip save(Trip entity);
   List<Trip> findAll();
   Optional<Trip> findByAllInclusive(String status);

    @Override
    Trip getById(Long id);
}
