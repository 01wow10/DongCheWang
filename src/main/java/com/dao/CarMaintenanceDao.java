package com.dao;

import com.model.CarMaintenance;
import com.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CarMaintenanceDao {
    public CarMaintenance getCarMaintenanceById(int id) {
        String sql = "SELECT * FROM car_maintenance WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new CarMaintenance(
                        rs.getInt("id"),
                        rs.getInt("car_rental_id"),
                        rs.getDate("maintenance_date").toLocalDate(),
                        rs.getString("maintenance_type"),
                        rs.getString("description"),
                        rs.getBigDecimal("cost")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CarMaintenance> getAllCarMaintenancesByCarRentalId(int carRentalId) {
        List<CarMaintenance> carMaintenances = new ArrayList<>();
        String sql = "SELECT * FROM car_maintenance WHERE car_rental_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, carRentalId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CarMaintenance carMaintenance = new CarMaintenance(
                        rs.getInt("id"),
                        rs.getInt("car_rental_id"),
                        rs.getDate("maintenance_date").toLocalDate(),
                        rs.getString("maintenance_type"),
                        rs.getString("description"),
                        rs.getBigDecimal("cost")
                );
                carMaintenances.add(carMaintenance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carMaintenances;
    }
}
