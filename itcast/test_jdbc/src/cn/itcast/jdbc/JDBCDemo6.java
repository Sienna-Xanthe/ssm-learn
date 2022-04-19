package cn.itcast.jdbc;

import java.sql.*;

public class JDBCDemo6 {
    public static void main(String[] args){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db1","root","root");
            String sql = "select * from stu";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            rs.next();
            int id = rs.getInt(1);
            String name = rs.getString("name");
            double score = rs.getDouble(3);
            System.out.println(id + "---" + name + "---" + score);



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(conn != null){
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}}
