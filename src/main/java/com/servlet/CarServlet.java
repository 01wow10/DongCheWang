package com.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.CarRental;
import com.dao.CarRentalDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/get-cars")
public class CarServlet extends HttpServlet {

    private CarRentalDAO carRentalDAO = new CarRentalDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CarRental> cars = carRentalDAO.getAllCars();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        new ObjectMapper().writeValue(response.getWriter(), cars);
    }
}
