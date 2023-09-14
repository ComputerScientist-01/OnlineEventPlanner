package com.demo.service;

import com.demo.model.Vendor;

import java.util.List;

public interface VendorService {
    Vendor findById(long vendorId);
    List<Vendor> findAll();
    void save(Vendor vendor);
    void update(Vendor vendor);
    void delete(long vendorId);
}
