package com.demo.service;

import com.demo.dao.PackageDAO;
import com.demo.model.Package;

import java.util.List;

public class PackageServiceImpl implements PackageService {

    private PackageDAO packageDAO;

    public PackageServiceImpl(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }

    @Override
    public Package findById(long packageId) {
        return packageDAO.findById(packageId);
    }

    @Override
    public List<Package> findAll() {
        return packageDAO.findAll();
    }

    @Override
    public void save(Package packageObj) {
        packageDAO.save(packageObj);
    }

    @Override
    public void update(Package packageObj) {
        packageDAO.update(packageObj);
    }

    @Override
    public void delete(long packageId) {
        packageDAO.delete(packageId);
    }
}
