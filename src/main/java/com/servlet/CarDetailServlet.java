// 假设这是一个 Servlet 示例
// D:\Project\DongCheWang\EX04\src\main\java\com\controller\CarDetailServlet.java
package com.servlet;

import com.dao.CarRentalDAO;
import com.dao.CarMaintenanceDAO;
import com.model.CarRental;
import com.model.CarMaintenance;
import com.service.CarDetailService;
import com.service.CarRentalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/car-detail")
public class CarDetailServlet extends HttpServlet {
    private CarDetailService carDetailService = new CarDetailService();
    private final CarRentalService carRentalService = new CarRentalService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carId = Integer.parseInt(request.getParameter("id"));
        CarRental car = carRentalService.getCarById(carId);
        List<CarMaintenance> maintenances = carDetailService.getMaintenanceByCarId(carId);

        request.setAttribute("car", car);
        request.setAttribute("maintenances", maintenances);
        request.getRequestDispatcher("/WEB-INF/views/car_details.jsp").forward(request, response);
    }
}
