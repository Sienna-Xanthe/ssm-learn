package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * stu 表删除一条数据
 */
public class JDBCDemo4 {
    public static void main(String[] args){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db1","root","root");
            String sql = "delete from stu where id = 2";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);

            if(count > 0){
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败");
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
