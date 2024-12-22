package com.dao;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class user_operation_dao extends Dao{
    public JSONArray get_rank(String rank_name) {
        String sql = "SELECT * FROM " + rank_name;  // 动态表名
        JSONArray jsonArray = new JSONArray();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", rs.getString("id"));
                jsonObject.put("ranking", rs.getString("ranking"));
                jsonObject.put("car_photo", rs.getString("car_photo")); // 假设 car_photo 是数据库字段
                jsonObject.put("model", rs.getString("model"));

                // 根据不同榜单返回不同的数值
                if (rank_name.equals("car_ranking_concern")) {
                    jsonObject.put("followers", rs.getInt("followers"));
                } else if (rank_name.equals("car_ranking_sales")) {
                    jsonObject.put("sales", rs.getInt("sales"));
                } else {
                    jsonObject.put("hedge", rs.getFloat("hedge"));
                }
                jsonArray.put(jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}
