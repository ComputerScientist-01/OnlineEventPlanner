package com.demo.model;

import java.sql.Date;

public class User {
    private long userId;
    private String fullName;
    private String username;
    private String password;
    private Date dateOfJoining;
    private Date dateOfBirth;
    private String department;
    private String mobile;
    private String email;
    private String location;
    private String status;

    // Constructors, getters, setters

    public User() {
    	super();
    }

    public User(long userId, String fullName, String username, String password, Date dateOfJoining,
                Date dateOfBirth, String department, String mobile, String email, String location, String status) {
        this.userId = userId;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.dateOfJoining = dateOfJoining;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.mobile = mobile;
        this.email = email;
        this.location = location;
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}