package com.dao;

import com.model.CarRental;
import com.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRentalDao extends Dao {

    public CarRental getCarRentalById(int id) {
        String sql = "SELECT * FROM car_rental WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new CarRental(
                        rs.getInt("id"),
                        rs.getInt("car_id"),
                        rs.getInt("user_id"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
                        rs.getBigDecimal("total_price"),
                        rs.getInt("status_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CarRental> getAllCarRentals() {
        List<CarRental> carRentals = new ArrayList<>();
        String sql = "SELECT * FROM car_rental";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                CarRental carRental = new CarRental(
                        rs.getInt("id"),
                        rs.getInt("car_id"),
                        rs.getInt("user_id"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
                        rs.getBigDecimal("total_price"),
                        rs.getInt("status_id")
                );
                carRentals.add(carRental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carRentals;
    }

    public void addRental(int carId, int userId, java.sql.Date startDate, java.sql.Date endDate, int statusId) {
        String sql = "INSERT INTO car_rental (car_id, user_id, start_date, end_date, status_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, carId);
            pstmt.setInt(2, userId);
            pstmt.setDate(3, startDate);
            pstmt.setDate(4, endDate);
            pstmt.setInt(5, statusId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRental(int rentalId, int carId, int userId, java.sql.Date startDate, java.sql.Date endDate, int statusId) {
        String sql = "UPDATE car_rental SET car_id = ?, user_id = ?, start_date = ?, end_date = ?, status_id = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, carId);
            pstmt.setInt(2, userId);
            pstmt.setDate(3, startDate);
            pstmt.setDate(4, endDate);
            pstmt.setInt(5, statusId);
            pstmt.setInt(6, rentalId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRental(int rentalId) {
        String sql = "DELETE FROM car_rental WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rentalId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CarRental> queryRentals(int carId, int userId, java.sql.Date startDate, java.sql.Date endDate) {
        List<CarRental> carRentals = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM car_rental WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (carId > 0) {
            sql.append(" AND car_id = ?");
            params.add(carId);
        }
        if (userId > 0) {
            sql.append(" AND user_id = ?");
            params.add(userId);
        }
        if (startDate != null) {
            sql.append(" AND start_date >= ?");
            params.add(startDate);
        }
        if (endDate != null) {
            sql.append(" AND end_date <= ?");
            params.add(endDate);
        }

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(i + 1, params.get(i));
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CarRental carRental = new CarRental(
                        rs.getInt("id"),
                        rs.getInt("car_id"),
                        rs.getInt("user_id"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
                        rs.getBigDecimal("total_price"),
                        rs.getInt("status_id")
                );
                carRentals.add(carRental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carRentals;
    }
}
