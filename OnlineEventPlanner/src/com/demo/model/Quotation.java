package com.demo.model;

public class Quotation {
    private long quotationId;
    private String packageType; // Basic / Premium / Classic
    private double estimatedAmount;
    private long userId; // Applicable for Classic package
    private long vendorId; // Applicable for Premium package
    private String status; // Accept / Reject / Pending (default: Pending)
    private long id;
    private long packageId;
    // Constructors, getters, setters

    public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getPackageId() {
		return packageId;
	}



	public void setPackageId(long packageId) {
		this.packageId = packageId;
	}



	public Quotation() {
        // Default constructor
    	super();
    }
    
    

    public Quotation(long quotationId, String packageType, double estimatedAmount, long userId, long vendorId, String status) {
        this.quotationId = quotationId;
        this.packageType = packageType;
        this.estimatedAmount = estimatedAmount;
        this.userId = userId;
        this.vendorId = vendorId;
        this.status = status;
    }

    public long getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(long quotationId) {
        this.quotationId = quotationId;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public double getEstimatedAmount() {
        return estimatedAmount;
    }

    public void setEstimatedAmount(double estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
