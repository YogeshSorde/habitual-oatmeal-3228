package com.service;

import java.util.List;

import com.dao.Flight;
import com.entity.Admin;

public interface AdminService {
    boolean registerAdmin(String username, String password);
    Admin loginAdmin(String username, String password);
    void addFlight(Flight flight);
    void updateFlight(Flight flight);
    void removeFlight(Flight flight);
    List<Flight> getAllFlights();
    // other admin-related methods
}