package com.dao;

import java.time.LocalDate;
import java.util.List;

import com.entity.Flight;

public interface FlightDao {
    List<Flight> findFlightsByCriteria(String departure, String arrival, LocalDate date, int passengerCount);
    Flight findById(Long id);
    void save(Flight flight);
    void update(Flight flight);
    void delete(Flight flight);
    // Other flight-related methods as needed
}
