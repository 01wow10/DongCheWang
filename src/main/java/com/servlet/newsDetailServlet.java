package com.servlet;
import com.dao.CarNewsDAO;
import com.model.CarNews;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newsDetail")
public class newsDetailServlet extends HttpServlet {
    private CarNewsDAO carNewsDAO = new CarNewsDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int newsId = Integer.parseInt(request.getParameter("id"));
        CarNews news= carNewsDAO.getNewsById(newsId);
        // 使用newsId从数据库中检索新闻详情
        // 将新闻详情存储在request属性中
        request.setAttribute("news", news);
        // 转发到新闻详情JSP页面
        RequestDispatcher dispatcher = request.getRequestDispatcher("/newsDetail.jsp");
        dispatcher.forward(request, response);
    }
}
