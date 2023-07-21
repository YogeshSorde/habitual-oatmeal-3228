package com.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.SessionFactory;

import com.entity.Flight;

import jakarta.persistence.Query;
import jakarta.transaction.Transaction;

public class FlightDaoImpl implements FlightDao {
    private SessionFactory sessionFactory;

    public FlightDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Flight> findFlightsByCriteria(String departure, String arrival, LocalDate date, int passengerCount) {
		return null;
        // Implement logic to find flights by criteria using Hibernate Session
    }



	@Override
	public void save(Flight flight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Flight flight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Flight flight) {
		// TODO Auto-generated method stub
		
	}

}


