package com.service;

import java.time.LocalDate;
import java.util.List;

import com.dao.Booking;
import com.dao.Flight;
import com.entity.Customer;

public interface CustomerService {
    void registerCustomer(String username, String password);
    void loginCustomer(String username, String password);
    List<com.ui.Flight> searchFlights(String departure, String arrival, LocalDate date, int passengerCount);
    void bookFlight(Customer customer, Flight flight, int passengerCount);
    List<com.service.Booking> getCustomerBookings(Long customerId);
    void cancelBooking(com.ui.Booking booking);
    // other customer-related methods
	com.ui.Flight getFlightById(long flightId);

}