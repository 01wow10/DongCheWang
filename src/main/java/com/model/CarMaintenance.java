package com.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CarMaintenance {
    private int id;
    private int carRentalId;
    private LocalDate maintenanceDate;
    private String maintenanceType;
    private String description;
    private BigDecimal cost;

    // 构造函数
    public CarMaintenance(int id, int carRentalId, LocalDate maintenanceDate, String maintenanceType, String description, BigDecimal cost) {
        this.id = id;
        this.carRentalId = carRentalId;
        this.maintenanceDate = maintenanceDate;
        this.maintenanceType = maintenanceType;
        this.description = description;
        this.cost = cost;
    }

    // Getters and setters
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

    public LocalDate getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(LocalDate maintenanceDate) {
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
