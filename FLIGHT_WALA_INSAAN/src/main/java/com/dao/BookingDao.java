package com.dao;

import java.util.List;

public interface BookingDao {
    void save(Booking booking);
    List<Booking> findBookingsByCustomerId(Long customerId);
    void delete(Booking booking);
    // other booking-related methods
}