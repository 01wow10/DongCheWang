package com.dao;

import com.servlet.User_Entry_Judgement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login_dao extends Dao{
    public String user_judgement(User_Entry_Judgement.User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String sql = "SELECT * FROM user_registration WHERE username= ? and password= ?;";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return "true";
            }
        } catch (Exception se) {
            se.printStackTrace();
        }
        return "false";
    }
}
