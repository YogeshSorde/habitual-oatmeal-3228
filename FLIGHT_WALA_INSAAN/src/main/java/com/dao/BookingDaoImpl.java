package com.dao;

import java.util.List;

import com.entity.Booking;
import com.mysql.cj.xdevapi.SessionFactory;

import jakarta.transaction.Transaction;

public class BookingDaoImpl implements BookingDao {
    private SessionFactory sessionFactory;

    public BookingDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

 

    @Override
    public List<Booking> findBookingsByCustomerId(Long customerId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Booking> query = session.createQuery("FROM Booking WHERE customer.id = :customerId", Booking.class);
            query.setParameter("customerId", customerId);
            return query.list();
        }
    }

 

	@Override
	public void save(Booking booking) {
		// TODO Auto-generated method stub
		
	     try (Session session = sessionFactory.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            session.save(booking);
	            transaction.commit();
	        }
		
	}

	@Override
	public void delete(Booking booking) {
		// TODO Auto-generated method stub
		  try (Session session = sessionFactory.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            session.delete(booking);
	            transaction.commit();
	        }
	}
}

