package com.servlet;

import com.model.CarMaintenance;
import com.service.CarRentalService;
import com.model.CarRental;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/rental")
public class RentalServlet extends HttpServlet {
    private CarRentalService carRentalService;

    public RentalServlet() {
        this.carRentalService = new CarRentalService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("getCarRental".equals(action)) {
            int carRentalId = Integer.parseInt(request.getParameter("carRentalId"));
            CarRental carRental = carRentalService.getCarRentalById(carRentalId);
            request.setAttribute("carRental", carRental);
        } else if ("getAllCarRentals".equals(action)) {
            List<CarRental> carRentals = carRentalService.getAllCarRentals();
            request.setAttribute("carRentals", carRentals);
        } else if ("getCarMaintenance".equals(action)) {
            int carMaintenanceId = Integer.parseInt(request.getParameter("carMaintenanceId"));
            CarMaintenance carMaintenance = carRentalService.getCarMaintenanceById(carMaintenanceId);
            request.setAttribute("carMaintenance", carMaintenance);
        } else if ("getAllCarMaintenancesByCarRentalId".equals(action)) {
            int carRentalId = Integer.parseInt(request.getParameter("carRentalId"));
            List<CarMaintenance> carMaintenances = carRentalService.getAllCarMaintenancesByCarRentalId(carRentalId);
            request.setAttribute("carMaintenances", carMaintenances);
        } else if ("query".equals(action)) {
            String carIdStr = request.getParameter("car_id");
            String userIdStr = request.getParameter("user_id");
            String startDateStr = request.getParameter("start_date");
            String endDateStr = request.getParameter("end_date");

            int carId = carIdStr != null && !carIdStr.isEmpty() ? Integer.parseInt(carIdStr) : 0;
            int userId = userIdStr != null && !userIdStr.isEmpty() ? Integer.parseInt(userIdStr) : 0;
            java.sql.Date startDate = startDateStr != null && !startDateStr.isEmpty() ? java.sql.Date.valueOf(startDateStr) : null;
            java.sql.Date endDate = endDateStr != null && !endDateStr.isEmpty() ? java.sql.Date.valueOf(endDateStr) : null;

            List<CarRental> rentals = carRentalService.queryRentals(carId, userId, startDate, endDate);
            request.setAttribute("rentals", rentals);
        }

        request.getRequestDispatcher("rental.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            int carId = Integer.parseInt(request.getParameter("car_id"));
            int userId = Integer.parseInt(request.getParameter("user_id"));
            java.sql.Date startDate = java.sql.Date.valueOf(request.getParameter("start_date"));
            java.sql.Date endDate = java.sql.Date.valueOf(request.getParameter("end_date"));
            int statusId = Integer.parseInt(request.getParameter("status_id"));

            carRentalService.addRental(carId, userId, startDate, endDate, statusId);
        } else if ("update".equals(action)) {
            int rentalId = Integer.parseInt(request.getParameter("rental_id"));
            int carId = Integer.parseInt(request.getParameter("car_id"));
            int userId = Integer.parseInt(request.getParameter("user_id"));
            java.sql.Date startDate = java.sql.Date.valueOf(request.getParameter("start_date"));
            java.sql.Date endDate = java.sql.Date.valueOf(request.getParameter("end_date"));
            int statusId = Integer.parseInt(request.getParameter("status_id"));

            carRentalService.updateRental(rentalId, carId, userId, startDate, endDate, statusId);
        } else if ("delete".equals(action)) {
            int rentalId = Integer.parseInt(request.getParameter("rental_id"));
            carRentalService.deleteRental(rentalId);
        }

        response.sendRedirect("rental?action=getAllCarRentals");
    }
}
