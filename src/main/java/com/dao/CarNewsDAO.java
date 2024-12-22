package com.dao;

import com.model.CarNews;
import com.model.news;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarNewsDAO {


    public boolean saveNews(CarNews carNews) {
        String query = "INSERT INTO car_news (title, car_photo, summary, content) VALUES (?, ?, ?, ?)";

        try (Connection conn = Dao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, carNews.getTitle());
            pstmt.setString(2, carNews.getCarPhoto());
            pstmt.setString(3, carNews.getSummary());
            pstmt.setString(4, carNews.getContent());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public CarNews getNewsById(int newsId) {
        String query = "SELECT * FROM car_news WHERE id = ?";

        try (Connection conn = Dao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, newsId); // 设置SQL查询中的ID参数

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) { // 如果查询结果中有记录
                    CarNews carNews = new CarNews();
                    carNews.setId(rs.getInt("id"));
                    carNews.setTitle(rs.getString("title"));
                    carNews.setCarPhoto(rs.getString("car_photo"));
                    carNews.setSummary(rs.getString("summary"));
                    carNews.setContent(rs.getString("content"));
                    return carNews;
                } else {
                    return null; // 没有找到对应的新闻记录
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CarNews> getAllCarNews() {

        List<CarNews> newsList = new ArrayList<>();


        String sql = "SELECT id, title, car_photo, summary, content FROM car_news";
        try (Connection conn = Dao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CarNews news = new CarNews();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setCarPhoto(rs.getString("car_photo"));
                news.setSummary(rs.getString("summary"));
                news.setContent(rs.getString("content"));
                newsList.add(news);
                System.out.println(news.getCarPhoto());
                System.out.println(news.getTitle());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsList;
    }
}