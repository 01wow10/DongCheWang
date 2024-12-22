package com.servlet;
import com.dao.CarNewsDAO;
import com.google.gson.Gson;
import com.model.CarNews;
import com.model.news;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/carNews")
@MultipartConfig
public class CarNewsServlet extends HttpServlet {

    private CarNewsDAO carNewsDAO = new CarNewsDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");  // 允许的来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

        System.out.println("Starting CarNewsServlet doGet method");

        resp.setContentType("application/json;charset=UTF-8");

        List<CarNews> newsList = carNewsDAO.getAllCarNews();
        req.setAttribute("newsList", newsList); // 将新闻列表设置到请求属性中
        resp.setContentType("text/html;charset=UTF-8");

        req.getRequestDispatcher("/newshow.jsp").forward(req, resp); // 转发请求

       /* Gson gson = new Gson();

        System.out.println("newsList size: " + (newsList != null ? newsList.size() : "null"));


        String json = gson.toJson(newsList); // 将 Java 对象转为 JSON

        System.out.println("Generated JSON: " + json);

        resp.getWriter().write(json); // 将 JSON 数据写入响应*/

    }



}