// D:\Project\DongCheWang\EX04\src\main\java\com\dongchewang\controller\CarDetailServlet.java
package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/car-detail")
public class CarDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String carId = request.getParameter("id");

        // 根据 carId 获取汽车详细信息
        // 这里假设你有一个方法 getCarById 来获取汽车信息
        Car car = getCarById(carId);

        // 将汽车信息存储在请求属性中
        request.setAttribute("car", car);

        // 转发到 car-detail.jsp 页面
        request.getRequestDispatcher("/car-detail.jsp").forward(request, response);
    }

    private Car getCarById(String carId) {
        // 实现获取汽车信息的逻辑
        // 这里只是一个示例
        return new Car(carId, "Brand", 10000, 5, 20000);
    }
}
