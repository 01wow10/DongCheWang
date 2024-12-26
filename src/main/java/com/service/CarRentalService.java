package com.service;

import com.dao.CarRentalDao;
import com.model.Car;
import com.model.Maintenance;

import java.util.List;

public class CarRentalService {
    private CarRentalDao carRentalDao;

    public CarRentalService() {
        this.carRentalDao = new CarRentalDao();
    }

    // 获取可租赁的汽车列表
    public List<Car> getAvailableCars() {
        return carRentalDao.getAvailableCars();
    }

    // 获取选中汽车的维护费用信息
    public List<Maintenance> getMaintenanceDetails(int carId) {
        return carRentalDao.getMaintenanceDetails(carId);
    }
}
