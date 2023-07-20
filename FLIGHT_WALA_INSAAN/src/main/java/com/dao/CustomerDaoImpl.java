package com.dao;

import com.entity.Customer;

import jakarta.transaction.Transaction;

public class CustomerDaoImpl implements CustomerDao {
    private SessionFactory sessionFactory;

    public CustomerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Customer findByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            Query<Customer> query = session.createQuery("FROM Customer WHERE username = :username", Customer.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        }
    }



	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		
		   try (Session session = sessionFactory.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            session.save(customer);
	            transaction.commit();
	        }
		
	}
}

