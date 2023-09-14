package com.demo.service;

import com.demo.dao.VendorDAO;
import com.demo.model.Vendor;

import java.util.List;

public class VendorServiceImpl implements VendorService {

    private VendorDAO vendorDAO;

    public VendorServiceImpl(VendorDAO vendorDAO) {
        this.vendorDAO = vendorDAO;
    }

    @Override
    public Vendor findById(long vendorId) {
        return vendorDAO.findById(vendorId);
    }

    @Override
    public List<Vendor> findAll() {
        return vendorDAO.findAll();
    }

    @Override
    public void save(Vendor vendor) {
        vendorDAO.save(vendor);
    }

    @Override
    public void update(Vendor vendor) {
        vendorDAO.update(vendor);
    }

    @Override
    public void delete(long vendorId) {
        vendorDAO.delete(vendorId);
    }
}
