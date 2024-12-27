package com.service;

import com.dao.CarRentalDAO;
import com.model.CarRental;

import java.util.List;

public class CarRentalService {
    private final CarRentalDAO carRentalDAO = new CarRentalDAO();

    public List<CarRental> getAllCars() {
        return carRentalDAO.getAllCars();
    }

    public CarRental getCarById(int id) {
        return carRentalDAO.getCarById(id);
    }
}