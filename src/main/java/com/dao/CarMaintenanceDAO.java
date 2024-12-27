package com.dao;

import com.model.CarMaintenance;
import com.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarMaintenanceDAO {
    public List<CarMaintenance> getMaintenanceByCarId(int carId) {
        List<CarMaintenance> maintenances = new ArrayList<>();
        String sql = "SELECT * FROM car_maintenance WHERE car_rental_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, carId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    CarMaintenance maintenance = new CarMaintenance(
                            rs.getInt("id"),
                            rs.getInt("car_rental_id"),
                            rs.getDate("maintenance_date"),
                            rs.getString("maintenance_type"),
                            rs.getString("description"),
                            rs.getDouble("cost")
                    );
                    maintenances.add(maintenance);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maintenances;
    }
}
