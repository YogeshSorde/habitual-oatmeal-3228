package com.service;

import java.time.LocalDate;
import java.util.List;

import com.dao.Booking;
import com.dao.BookingDao;
import com.dao.CustomerDao;
import com.dao.Flight;
import com.dao.FlightDao;
import com.entity.Customer;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;
    private FlightDao flightDao;
    private BookingDao bookingDao;

    public CustomerServiceImpl(CustomerDao customerDao, FlightDao flightDao, BookingDao bookingDao) {
        this.customerDao = customerDao;
        this.flightDao = flightDao;
        this.bookingDao = bookingDao;
    }

    @Override
    public boolean registerCustomer(String username, String password) {
        // Implement customer registration logic
    }

    @Override
    public Customer loginCustomer(String username, String password) {
        // Implement customer login logic
    }


 
    @Override
    public List<Booking> getCustomerBookings(Long customerId) {
        // Implement logic to get customer bookings
    }

   

	@Override
	public List<Flight> searchFlights(String departure, String arrival, LocalDate date, int passengerCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bookFlight(Customer customer, Flight flight, int passengerCount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelBooking(Booking booking) {
		// TODO Auto-generated method stub
		
	}
}
