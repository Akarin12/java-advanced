package com.soft1841.jdbc;

import java.sql.*;

public class JDBCDemo2 {
    //JDBC驱动名及数据库连接URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db_jdbc?useUnicode=true&characterEncoding=utf8";
    static final String USER = "root";
    static final String PASS = "root";
    public static void main(String[] args)throws SQLException,ClassNotFoundException{
        Class.forName(JDBC_DRIVER);
        //建立连接
        System.out.println("连接数据库.....");
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
        String sql = "INSERT INTO t_student(name,age) VALUES(?,?)";
        System.out.println("实例化PreparedStatement对象.....");
        PreparedStatement pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,"测试用户");
        pstmt.setInt(2,20);
        int n = pstmt.executeUpdate();
        System.out.println(n+"行记录受影响");
        pstmt.close();
        conn.close();
    }
}