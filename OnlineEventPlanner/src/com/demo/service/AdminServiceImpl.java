package com.demo.service;

import com.demo.dao.AdminDAO;
import com.demo.model.Admin;

public class AdminServiceImpl implements AdminService {

    private AdminDAO adminDAO;

    public AdminServiceImpl(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public Admin findById(long adminId) {
        return adminDAO.findById(adminId);
    }

    @Override
    public Admin findByUsername(String username) {
        return adminDAO.findByUsername(username);
    }
}
