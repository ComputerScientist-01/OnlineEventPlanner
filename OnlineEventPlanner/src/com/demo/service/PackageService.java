package com.demo.service;

import com.demo.model.Package;

import java.util.List;

public interface PackageService {
    Package findById(long packageId);
    List<Package> findAll();
    void save(Package packageObj);
    void update(Package packageObj);
    void delete(long packageId);
}
