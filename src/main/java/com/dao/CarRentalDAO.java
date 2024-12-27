package com.dao;

import com.model.CarRental;
import com.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRentalDAO {
    public List<CarRental> getAllCars() {
        List<CarRental> cars = new ArrayList<>();
        String sql = "SELECT * FROM car_rental";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CarRental car = new CarRental(
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

    public CarRental getCarById(int id) {
        String sql = "SELECT * FROM car_rental WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CarRental(
                            rs.getInt("id"),
                            rs.getString("car_photo"),
                            rs.getString("contact_way"),
                            rs.getString("brand"),
                            rs.getFloat("mileage"),
                            rs.getInt("age"),
                            rs.getFloat("price")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
