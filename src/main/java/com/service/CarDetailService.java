package com.service;

import com.dao.CarMaintenanceDAO;
import com.model.CarMaintenance;

import java.util.List;

public class CarDetailService {
    private CarMaintenanceDAO carMaintenanceDAO = new CarMaintenanceDAO();


    public List<CarMaintenance> getMaintenanceByCarId(int carId) {
        return carMaintenanceDAO.getMaintenanceByCarId(carId);
    }
}
