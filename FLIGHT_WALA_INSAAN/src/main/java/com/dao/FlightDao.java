package com.dao;

import java.time.LocalDate;
import java.util.List;

public interface FlightDao {
    List<Flight> findFlightsByCriteria(String departure, String arrival, LocalDate date, int passengerCount);
    void save(Flight flight);
    void update(Flight flight);
    void delete(Flight flight);
}
