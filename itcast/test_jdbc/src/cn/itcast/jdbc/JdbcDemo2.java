package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * stu表 添加一条记录 insert 语句
 */
public class JdbcDemo2 {
    public static void main(String[] args){
        Statement stmt = null;
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "insert into stu value(3,'大头',12,66,null,'2021-09-22 18:46:54')";

            conn = DriverManager.getConnection("jdbc:mysql:///db1","root","root");

            stmt = conn.createStatement();

            int count = stmt.executeUpdate(sql);

            System.out.println(count);
            if(count > 0)
            {
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //stmt.close();
            //避免空指针异常
            if(stmt != null){
                try{
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null){
                try{
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
