package com.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
//    public static DataSource getDataSource(){
//        DataSource dataSource =null;
//        try {
//            Context context =new InitialContext();
//            dataSource =(DataSource) context.lookup("java:comp/env/jdbc/companydata");
//        }catch (NamingException ne){
//            System.out.println("异常:"+ne);
//        }
//        return dataSource;
//    }
//    public static Connection getConnection() throws DaoException{
//        DataSource dataSource=getDataSource();
//        Connection conn=null;
//        try{
//            conn = dataSource.getConnection();
//        }catch (SQLException sqle){
//            System.out.println("异常:"+sqle);
//        }
//        return conn;
//    }
    public static Connection getConnection(){
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String dburl = "jdbc:mysql://localhost:3306/car";
        String username = "root"; //数据库登录用户名
        String password = "123456"; //数据库登录密码
        try{
            Class.forName(driver); //加载数据库驱动程序
            conn = DriverManager.getConnection(dburl,username,password);
        }catch( Exception e ){ e.printStackTrace(); }
        return conn;
    }
}
