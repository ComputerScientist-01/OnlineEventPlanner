package com.demo.service;



import com.demo.model.Admin;

public interface AdminService {
    Admin findById(long adminId);
    Admin findByUsername(String username);
}