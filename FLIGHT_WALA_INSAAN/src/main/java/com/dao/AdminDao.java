package com.dao;

import com.entity.Admin;

public interface AdminDao {
    Admin findByUsername(String username);
    void save(Admin admin);
    // Other admin-related methods as needed
}
