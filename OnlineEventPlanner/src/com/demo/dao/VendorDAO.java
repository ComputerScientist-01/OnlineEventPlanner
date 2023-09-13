package com.demo.dao;

import com.demo.model.Vendor;

import java.util.List;

public interface VendorDAO {
    Vendor findById(long vendorId);
    List<Vendor> findAll();
    void save(Vendor vendor);
    void update(Vendor vendor);
    void delete(long vendorId);
}
