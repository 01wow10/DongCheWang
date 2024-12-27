package com.servlet;

import com.service.CarRentalService;
import com.model.CarRental;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cars")
public class CarListServlet extends HttpServlet {
    private final CarRentalService carRentalService = new CarRentalService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CarRental> cars = carRentalService.getAllCars();
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/WEB-INF/jsp/cars.jsp").forward(req, resp);
    }
}