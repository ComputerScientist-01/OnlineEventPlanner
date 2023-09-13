package com.demo.model;

import java.util.Date;
import java.util.List;

public class PlanRequest {
    private long requestId;
    private Date fromDate;
    private Date toDate;
    private List<String> servicesNeeded; // List of services needed
    private int numberOfPersonsAttending;
    private String otherServices;

    // Constructors, getters, setters

    // Default constructor
    public PlanRequest() {
    	super();
    }

    public PlanRequest(long requestId, Date fromDate, Date toDate, List<String> servicesNeeded,
                       int numberOfPersonsAttending, String otherServices) {
        this.requestId = requestId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.servicesNeeded = servicesNeeded;
        this.numberOfPersonsAttending = numberOfPersonsAttending;
        this.otherServices = otherServices;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public List<String> getServicesNeeded() {
        return servicesNeeded;
    }

    public void setServicesNeeded(List<String> servicesNeeded) {
        this.servicesNeeded = servicesNeeded;
    }

    public int getNumberOfPersonsAttending() {
        return numberOfPersonsAttending;
    }

    public void setNumberOfPersonsAttending(int numberOfPersonsAttending) {
        this.numberOfPersonsAttending = numberOfPersonsAttending;
    }

    public String getOtherServices() {
        return otherServices;
    }

    public void setOtherServices(String otherServices) {
        this.otherServices = otherServices;
    }
}
