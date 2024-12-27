package com.model;

import java.util.Date;

public class CarMaintenance {
    private int id;
    private int carRentalId;
    private Date maintenanceDate;
    private String maintenanceType;
    private String description;
    private double cost;

    public CarMaintenance(int id, int carRentalId, Date maintenanceDate, String maintenanceType, String description, double cost) {
        this.id = id;
        this.carRentalId = carRentalId;
        this.maintenanceDate = maintenanceDate;
        this.maintenanceType = maintenanceType;
        this.description = description;
        this.cost = cost;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarRentalId() {
        return carRentalId;
    }

    public void setCarRentalId(int carRentalId) {
        this.carRentalId = carRentalId;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
