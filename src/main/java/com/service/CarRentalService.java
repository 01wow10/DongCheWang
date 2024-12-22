package com.service;

import com.dao.CarRentalDao;
import com.model.Rental;

import java.util.List;

public class CarRentalService {
    private CarRentalDao carRentalDao;

    public CarRentalService() {
        this.carRentalDao = new CarRentalDao();
    }

    public boolean addRental(int carId, int userId, String startDate, String endDate, double totalPrice, int statusId) {
        return carRentalDao.addRental(carId, userId, startDate, endDate, totalPrice, statusId);
    }

    public boolean updateRental(int rentalId, int carId, int userId, String startDate, String endDate, double totalPrice, int statusId) {
        return carRentalDao.updateRental(rentalId, carId, userId, startDate, endDate, totalPrice, statusId);
    }

    public boolean deleteRental(int rentalId) {
        return carRentalDao.deleteRental(rentalId);
    }

    public Rental getRentalById(int rentalId) {
        return carRentalDao.getRentalById(rentalId);
    }

    public List<Rental> getAllRentals() {
        return carRentalDao.getAllRentals();
    }
}
