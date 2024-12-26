package com.dao;

import com.model.Car;
import com.model.Maintenance;
import com.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRentalDao extends Dao {

    // 获取可租赁的汽车列表
    public List<Car> getAvailableCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM car_rental";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Car car = new Car(
                        rs.getInt("id"),
                        rs.getString("car_photo"),
                        rs.getString("contact_way"),
                        rs.getString("brand"),
                        rs.getFloat("mileage"),
                        rs.getInt("age"),
                        rs.getFloat("price")
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    // 获取选中汽车的维护费用信息
    public List<Maintenance> getMaintenanceDetails(int carId) {
        List<Maintenance> maintenances = new ArrayList<>();
        String sql = "SELECT * FROM car_maintenance WHERE car_rental_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, carId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Maintenance maintenance = new Maintenance(
                        rs.getInt("id"),
                        rs.getInt("car_rental_id"),
                        rs.getDate("maintenance_date").toLocalDate(),
                        rs.getString("maintenance_type"),
                        rs.getString("description"),
                        rs.getBigDecimal("cost").doubleValue()
                );
                maintenances.add(maintenance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maintenances;
    }
}
