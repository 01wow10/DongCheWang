package com.servlet;

import com.model.Car;
import com.model.Maintenance;
import com.service.CarRentalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
        if ("list".equals(action)) {
            listAvailableCars(request, response);
        } else if ("details".equals(action)) {
            int carId = Integer.parseInt(request.getParameter("carId"));
            listMaintenanceDetails(request, response, carId);
        }
    }

    private void listAvailableCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> cars = carRentalService.getAvailableCars();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("[");
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            out.print("{");
            out.print("\"id\":" + car.getId() + ",");
            out.print("\"carPhoto\":\"" + car.getCarPhoto() + "\",");
            out.print("\"contactWay\":\"" + car.getContactWay() + "\",");
            out.print("\"brand\":\"" + car.getBrand() + "\",");
            out.print("\"mileage\":" + car.getMileage() + ",");
            out.print("\"age\":" + car.getAge() + ",");
            out.print("\"price\":" + car.getPrice());
            out.print("}");
            if (i < cars.size() - 1) {
                out.print(",");
            }
        }
        out.print("]");
    }

    private void listMaintenanceDetails(HttpServletRequest request, HttpServletResponse response, int carId) throws ServletException, IOException {
        List<Maintenance> maintenances = carRentalService.getMaintenanceDetails(carId);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("[");
        for (int i = 0; i < maintenances.size(); i++) {
            Maintenance maintenance = maintenances.get(i);
            out.print("{");
            out.print("\"id\":" + maintenance.getId() + ",");
            out.print("\"carRentalId\":" + maintenance.getCarRentalId() + ",");
            out.print("\"maintenanceDate\":\"" + maintenance.getMaintenanceDate() + "\",");
            out.print("\"maintenanceType\":\"" + maintenance.getMaintenanceType() + "\",");
            out.print("\"description\":\"" + maintenance.getDescription() + "\",");
            out.print("\"cost\":" + maintenance.getCost());
            out.print("}");
            if (i < maintenances.size() - 1) {
                out.print(",");
            }
        }
        out.print("]");
    }
}
