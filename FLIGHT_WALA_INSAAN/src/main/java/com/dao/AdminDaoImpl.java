package com.dao;

import org.hibernate.SessionFactory;

import com.entity.Admin;

import jakarta.transaction.Transaction;

public class AdminDaoImpl implements AdminDao {
    private SessionFactory sessionFactory;

    public AdminDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Admin findByUsername(String username) {
		return null;
        // Implement logic to find an admin by username using Hibernate Session
    }

    @Override
    public void save(Admin admin) {
        // Implement logic to save an admin using Hibernate Session
    }

    // Implement other admin-related methods as needed
}
