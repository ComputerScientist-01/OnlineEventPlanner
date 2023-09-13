package com.demo.model;

import java.util.List;

public class Package {
    private long packageId;
    private String type;
    private String packageType;
    private List<String> services; // List of services associated with the package
    private double amount;

    // Constructors, getters, setters

    // Default constructor
    public Package() {
    	super();
    }

    public Package(long packageId, String type, String packageType, List<String> services, double amount) {
        this.packageId = packageId;
        this.type = type;
        this.packageType = packageType;
        this.services = services;
        this.amount = amount;
    }

    public long getPackageId() {
        return packageId;
    }

    public void setPackageId(long packageId) {
        this.packageId = packageId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
