package com.demo.dao;

import com.demo.model.Package;

import java.util.List;

public interface PackageDAO {
    Package findById(long packageId);
    List<Package> findAll();
    void save(Package aPackage);
    void update(Package aPackage);
    void delete(long packageId);
}
