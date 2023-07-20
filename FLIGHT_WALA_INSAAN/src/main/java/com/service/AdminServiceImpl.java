package com.service;

import java.util.List;

import com.dao.AdminDao;
import com.dao.Flight;
import com.dao.FlightDao;
import com.entity.Admin;
import com.exception.FlightBookingException;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao;
    private FlightDao flightDao;

    public AdminServiceImpl(AdminDao adminDao, FlightDao flightDao) {
        this.adminDao = adminDao;
        this.flightDao = flightDao;
    }

    @Override
    public boolean registerAdmin(String username, String password) {
    	 if (adminDao.findByUsername(username) != null) {
             throw new FlightBookingException("Username already exists. Please choose a different username.");
         }

         Admin admin = new Admin(null, password, password);
         admin.setUsername(username);
         admin.setPassword(password);

         adminDao.save(admin);
         return true;
    }

    @Override
    public Admin loginAdmin(String username, String password) {
        // Implement admin login logic
    	
        Admin admin = adminDao.findByUsername(username);
        if (admin == null || !admin.getPassword().equals(password)) {
            throw new FlightBookingException("Invalid username or password. Please try again.");
        }

        return admin;
    }
    


    @Override
    public List<Flight> getAllFlights() {
    	  return flightDao.getAllFlights();
    }


	@Override
	public void addFlight(Flight flight) {
		 flightDao.save(flight);
		
	}

	@Override
	public void updateFlight(Flight flight) {
	     flightDao.update(flight);
		
	}

	@Override
	public void removeFlight(Flight flight) {
		flightDao.delete(flight);
		
	}
}
