package com.service;

import java.util.List;

import com.dao.AdminDao;
import com.dao.Flight;
import com.dao.FlightDao;
import com.entity.Admin;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao;
    private FlightDao flightDao;

    public AdminServiceImpl(AdminDao adminDao, FlightDao flightDao) {
        this.adminDao = adminDao;
        this.flightDao = flightDao;
    }

    @Override
    public boolean registerAdmin(String username, String password) {
        // Implement admin registration logic
    }

    @Override
    public Admin loginAdmin(String username, String password) {
        // Implement admin login logic
    }


    @Override
    public List<Flight> getAllFlights() {
        // Implement logic to get all flights
    }
    // Implement other admin-related methods

	@Override
	public void addFlight(Flight flight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFlight(Flight flight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFlight(Flight flight) {
		// TODO Auto-generated method stub
		
	}
}
