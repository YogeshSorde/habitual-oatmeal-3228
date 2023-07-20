package com.dao;

import com.entity.Admin;

public interface AdminDao {
    Admin findByUsername(String username);
    void save(Admin admin);
}

