package com.service;

import java.time.LocalDate;
import java.util.List;

import com.dao.Booking;
import com.dao.Flight;
import com.entity.Customer;

public interface CustomerService {
    boolean registerCustomer(String username, String password);
    Customer loginCustomer(String username, String password);
    List<Flight> searchFlights(String departure, String arrival, LocalDate date, int passengerCount);
    void bookFlight(Customer customer, Flight flight, int passengerCount);
    List<Booking> getCustomerBookings(Long customerId);
    void cancelBooking(Booking booking);
    // other customer-related methods
}