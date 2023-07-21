package com.dao;

import com.entity.Customer;

public interface CustomerDao {
    Customer findByUsername(String username);
    void save(Customer customer);
    // Other customer-related methods as needed
}
