package com.dao;

import com.entity.Admin;

import jakarta.transaction.Transaction;

public class AdminDaoImpl implements AdminDao {
    private SessionFactory sessionFactory;

    public AdminDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Admin findByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            Query<Admin> query = session.createQuery("FROM Admin WHERE username = :username", Admin.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        }
    }

    @Override
    public void save(Admin admin) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(admin);
            transaction.commit();
        }
    }

	

}
