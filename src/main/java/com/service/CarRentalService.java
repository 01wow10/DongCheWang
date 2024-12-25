package com.service;

import com.dao.CarMaintenanceDao;
import com.dao.CarRentalDao;
import com.model.CarMaintenance;
import com.model.CarRental;

import java.util.List;

public class CarRentalService {
    private CarRentalDao carRentalDao;
    private CarMaintenanceDao carMaintenanceDao;

    public CarRentalService() {
        this.carRentalDao = new CarRentalDao();
        this.carMaintenanceDao = new CarMaintenanceDao();
    }

    // CarRental methods
    public CarRental getCarRentalById(int id) {
        return carRentalDao.getCarRentalById(id);
    }

    public List<CarRental> getAllCarRentals() {
        return carRentalDao.getAllCarRentals();
    }

    public void addRental(int carId, int userId, java.sql.Date startDate, java.sql.Date endDate, int statusId) {
        carRentalDao.addRental(carId, userId, startDate, endDate, statusId);
    }

    public void updateRental(int rentalId, int carId, int userId, java.sql.Date startDate, java.sql.Date endDate, int statusId) {
        carRentalDao.updateRental(rentalId, carId, userId, startDate, endDate, statusId);
    }

    public void deleteRental(int rentalId) {
        carRentalDao.deleteRental(rentalId);
    }

    public List<CarRental> queryRentals(int carId, int userId, java.sql.Date startDate, java.sql.Date endDate) {
        return carRentalDao.queryRentals(carId, userId, startDate, endDate);
    }

    // CarMaintenance methods
    public CarMaintenance getCarMaintenanceById(int id) {
        return carMaintenanceDao.getCarMaintenanceById(id);
    }

    public List<CarMaintenance> getAllCarMaintenancesByCarRentalId(int carRentalId) {
        return carMaintenanceDao.getAllCarMaintenancesByCarRentalId(carRentalId);
    }
}
