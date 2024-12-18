package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test extends Dao{
    public static void main(String[] args) {
        String sql="SELECT * FROM employee_information";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("姓名"));
            }
        } catch (Exception se) {
            se.printStackTrace();
        }
    }
}
