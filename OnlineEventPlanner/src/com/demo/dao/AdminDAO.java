package com.demo.dao;

import com.demo.model.Admin;

public interface AdminDAO {
    Admin findById(long adminId);
    Admin findByUsername(String username);
}
