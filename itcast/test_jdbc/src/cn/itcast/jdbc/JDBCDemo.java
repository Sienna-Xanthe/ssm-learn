package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account表 修改记录
 */
public class JDBCDemo {
    public static void main(String[] args){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db1","root","root");
            String sql = "update stu stu set age = 33 where id = 2";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);

            if(count > 0){
                System.out.println("修改成功！");
            }else{
                System.out.println("修改失败");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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
}
