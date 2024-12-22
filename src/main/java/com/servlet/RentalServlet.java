package com.servlet;

import com.model.Rental;
import com.service.CarRentalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

        if ("get".equals(action)) {
            int rentalId = Integer.parseInt(request.getParameter("rental_id"));
            Rental rental = carRentalService.getRentalById(rentalId);
            request.setAttribute("rental", rental);
        } else if ("getAll".equals(action)) {
            List<Rental> rentals = carRentalService.getAllRentals();
            request.setAttribute("rentals", rentals);
        }

        request.getRequestDispatcher("rental.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            handleAddRental(request, response);
        } else if ("update".equals(action)) {
            handleUpdateRental(request, response);
        } else if ("delete".equals(action)) {
            handleDeleteRental(request, response);
        }
    }

    private void handleAddRental(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int carId = Integer.parseInt(request.getParameter("car_id"));
        int userId = Integer.parseInt(request.getParameter("user_id"));
        String startDateStr = request.getParameter("start_date");
        String endDateStr = request.getParameter("end_date");
        int statusId = Integer.parseInt(request.getParameter("status_id"));

        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        double totalPrice = calculateTotalPrice(carId, startDate, endDate);

        if (carRentalService.addRental(carId, userId, startDate.toString(), endDate.toString(), totalPrice, statusId)) {
            response.sendRedirect("rental?action=getAll");
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to add rental.");
        }
    }

    private void handleUpdateRental(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int rentalId = Integer.parseInt(request.getParameter("rental_id"));
        int carId = Integer.parseInt(request.getParameter("car_id"));
        int userId = Integer.parseInt(request.getParameter("user_id"));
        String startDateStr = request.getParameter("start_date");
        String endDateStr = request.getParameter("end_date");
        int statusId = Integer.parseInt(request.getParameter("status_id"));

        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        double totalPrice = calculateTotalPrice(carId, startDate, endDate);

        if (carRentalService.updateRental(rentalId, carId, userId, startDate.toString(), endDate.toString(), totalPrice, statusId)) {
            response.sendRedirect("rental?action=getAll");
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to update rental.");
        }
    }

    private void handleDeleteRental(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int rentalId = Integer.parseInt(request.getParameter("rental_id"));

        if (carRentalService.deleteRental(rentalId)) {
            response.sendRedirect("rental?action=getAll");
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to delete rental.");
        }
    }

    private double calculateTotalPrice(int carId, LocalDate startDate, LocalDate endDate) {
        // Assuming there is a method in the service or dao layer to get the car's price per day.
        double pricePerDay = carRentalService.getPricePerDay(carId);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return BigDecimal.valueOf(daysBetween * pricePerDay).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
