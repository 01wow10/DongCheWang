package com.dao;

import com.model.Rental;
import com.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRentalDao extends Dao {

    public boolean addRental(int carId, int userId, String startDate, String endDate, double totalPrice, int statusId) {
        String sql = "INSERT INTO car_rental (car_id, user_id, start_date, end_date, total_price, status_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, carId);
            pstmt.setInt(2, userId);
            pstmt.setDate(3, Date.valueOf(startDate));
            pstmt.setDate(4, Date.valueOf(endDate));
            pstmt.setDouble(5, totalPrice);
            pstmt.setInt(6, statusId);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateRental(int rentalId, int carId, int userId, String startDate, String endDate, double totalPrice, int statusId) {
        String sql = "UPDATE car_rental SET car_id=?, user_id=?, start_date=?, end_date=?, total_price=?, status_id=? WHERE rental_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, carId);
            pstmt.setInt(2, userId);
            pstmt.setDate(3, Date.valueOf(startDate));
            pstmt.setDate(4, Date.valueOf(endDate));
            pstmt.setDouble(5, totalPrice);
            pstmt.setInt(6, statusId);
            pstmt.setInt(7, rentalId);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteRental(int rentalId) {
        String sql = "DELETE FROM car_rental WHERE rental_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rentalId);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Rental getRentalById(int rentalId) {
        String sql = "SELECT cr.*, rs.status_name FROM car_rental cr JOIN rental_status rs ON cr.status_id = rs.status_id WHERE cr.rental_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rentalId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Rental(
                        rs.getInt("rental_id"),
                        rs.getInt("car_id"),
                        rs.getInt("user_id"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
                        rs.getDouble("total_price"),
                        rs.getString("status_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Rental> getAllRentals() {
        List<Rental> rentals = new ArrayList<>();
        String sql = "SELECT cr.*, rs.status_name FROM car_rental cr JOIN rental_status rs ON cr.status_id = rs.status_id";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Rental rental = new Rental(
                        rs.getInt("rental_id"),
                        rs.getInt("car_id"),
                        rs.getInt("user_id"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
                        rs.getDouble("total_price"),
                        rs.getString("status_name")
                );
                rentals.add(rental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }
}
