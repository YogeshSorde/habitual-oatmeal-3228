package com.dao;

import java.util.List;

public interface Fligh {
    void addFlight(Flight flight);
    void updateFlight(Flight flight);
    void removeFlight(Flight flight);
    List<Flight> getAllFlights();
    Flight getFlightById(int flightId);
    List<Flight> searchFlights(String departure, String destination, String date);
    List<Flight> filterFlightsByPriceRange(double minPrice, double maxPrice);
    List<Flight> filterFlightsByDepartureTime(String startTime, String endTime);
}