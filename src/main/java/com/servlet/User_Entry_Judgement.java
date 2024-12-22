package com.servlet;
import com.google.gson.Gson;
import org.json.JSONObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import com.dao.login_dao;

@WebServlet(urlPatterns ="/User_Entry_Judgement")
public class User_Entry_Judgement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 从请求体读取 JSON 数据
        StringBuilder jsonBuffer = new StringBuilder();
        String line;
        while ((line = request.getReader().readLine()) != null) {
            jsonBuffer.append(line);
        }
        String jsonData = jsonBuffer.toString();

        // 解析 JSON 数据
        JSONObject jsonObject = new JSONObject(jsonData);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        // 处理登录逻辑
        login_dao dao = new login_dao();
        String result = dao.user_judgement(new User(username, password));

        // 返回结果
        JSONObject responseJson = new JSONObject();
        responseJson.put("message", result);
        response.getWriter().write(responseJson.toString());
    }

    public class User {
        private String password;
        private String username;
        public User(){}
        public User(String username,String password){
            this.username=username;
            this.password=password;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
