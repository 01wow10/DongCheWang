package com.servlet;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.dao.user_operation_dao;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet( urlPatterns = { "/get_rank"})
public class get_rank extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 模拟获取数据的逻辑
        List<RankItem> salesRanking = getSalesRanking();
        List<RankItem> focusRanking = getFocusRanking();
        List<RankItem> valueRetentionRanking = getValueRetentionRanking();

        // 设置响应内容类型为 JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 获取请求参数，用于判断请求的榜单
        String rankingType = request.getParameter("rankingType");

        // 根据请求参数返回对应的榜单数据
        PrintWriter out = response.getWriter();
        if ("sales".equals(rankingType)) {
            out.write(new Gson().toJson(salesRanking));
        } else if ("focus".equals(rankingType)) {
            out.write(new Gson().toJson(focusRanking));
        } else {
            out.write(new Gson().toJson(valueRetentionRanking));
        }
        out.flush();
    }

    // 模拟获取销量榜数据
    private List<RankItem> getSalesRanking() {
        List<RankItem> list = new ArrayList<>();
        user_operation_dao dao = new user_operation_dao();
        JSONArray jsonArray = dao.get_rank("car_ranking_sales"); // 获取数据

        // 遍历返回的 JSONArray，将每一项转换为 RankItem，并添加到 list 中
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String model = jsonObject.getString("model"); // 获取车型
            int value = jsonObject.getInt("sales"); // 获取销量
            String car_photo = jsonObject.getString("car_photo");

            // 创建 RankItem 对象，并将其添加到 list
            list.add(new RankItem(model, value,car_photo));
        }

        return list; // 返回包含排名数据的 list
    }


    // 模拟获取关注榜数据
    private List<RankItem> getFocusRanking() {
        List<RankItem> list = new ArrayList<>();
        user_operation_dao dao = new user_operation_dao();
        JSONArray jsonArray = dao.get_rank("car_ranking_concern"); // 获取数据

        // 遍历返回的 JSONArray，将每一项转换为 RankItem，并添加到 list 中
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String model = jsonObject.getString("model"); // 获取车型
            int value = jsonObject.getInt("followers"); //
            String car_photo = jsonObject.getString("car_photo");

            // 创建 RankItem 对象，并将其添加到 list
            list.add(new RankItem(model, value,car_photo));
        }

        return list; // 返回包含排名数据的 list
    }

    // 模拟获取保值榜数据
    private List<RankItem> getValueRetentionRanking() {
        List<RankItem> list = new ArrayList<>();
        user_operation_dao dao = new user_operation_dao();
        JSONArray jsonArray = dao.get_rank("car_ranking_hedge"); // 获取数据

        // 遍历返回的 JSONArray，将每一项转换为 RankItem，并添加到 list 中
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String model = jsonObject.getString("model"); // 获取车型
            int value = jsonObject.getInt("hedge"); //
            String car_photo = jsonObject.getString("car_photo");

            // 创建 RankItem 对象，并将其添加到 list
            list.add(new RankItem(model, value,car_photo));
        }

        return list; // 返回包含排名数据的 list
    }

    // 定义一个简单的 RankItem 类，用于封装数据
    public static class RankItem {
        private String model;
        private int value;

        private String car_photo;

        public RankItem(String model, int value,String car_photo) {
            this.model = model;
            this.value = value;
            this.car_photo = car_photo;
        }

        public String getCar_photo() {
            return car_photo;
        }

        public void setCar_photo(String car_photo) {
            this.car_photo = car_photo;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
