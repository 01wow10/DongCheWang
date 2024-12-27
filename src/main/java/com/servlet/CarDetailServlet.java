package com.servlet;

import com.dao.CarRentalDAO;
import com.dao.CarMaintenanceDAO;
import com.model.CarRental;
import com.model.CarMaintenance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/car-detail")
public class CarDetailServlet extends HttpServlet {
    private CarRentalDAO carRentalDAO = new CarRentalDAO();
    private CarMaintenanceDAO carMaintenanceDAO = new CarMaintenanceDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carId = Integer.parseInt(request.getParameter("id"));
        CarRental car = carRentalDAO.getCarById(carId);
        List<CarMaintenance> maintenances = carMaintenanceDAO.getMaintenanceByCarId(carId);

        request.setAttribute("car", car);
        request.setAttribute("maintenances", maintenances);
        request.getRequestDispatcher("/WEB-INF/EX04_war/car-detail.jsp").forward(request, response);
    }
}
