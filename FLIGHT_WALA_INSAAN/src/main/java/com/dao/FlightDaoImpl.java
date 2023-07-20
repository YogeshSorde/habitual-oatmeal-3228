package com.dao;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Query;
import jakarta.transaction.Transaction;

public class FlightDaoImpl implements FlightDao {
    private SessionFactory sessionFactory;

    public FlightDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

 
    @Override
    public void save(Flight flight) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(flight);
            transaction.commit();
        }
    }

    @Override
    public void update(Flight flight) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(flight);
            transaction.commit();
        }
    }

    @Override
    public void delete(Flight flight) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(flight);
            transaction.commit();
        }
    }

	@Override
	public List<Flight> findFlightsByCriteria(String departure, String arrival, LocalDate date, int passengerCount) {
		// TODO Auto-generated method stub
		 try (Session session = sessionFactory.openSession()) {
	            // Implement the query to find flights based on criteria
	            // For example:
	            Query<Flight> query = session.createQuery(
	                    "FROM Flight WHERE departure = :departure AND arrival = :arrival", Flight.class
	            );
	            query.setParameter("departure", departure);
	            query.setParameter("arrival", arrival);
	            return query.list();
	        }
	}
}

