package com.dao;

import java.util.List;

import com.entity.Booking;

public interface BookingDao {
    void save(Booking booking);
    List<Booking> findBookingsByCustomerId(Long customerId);
    void delete(Booking booking);
}
