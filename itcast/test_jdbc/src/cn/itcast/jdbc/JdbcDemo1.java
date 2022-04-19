package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc快速入门
 */
public class JdbcDemo1 {
    public static void main(String[] arg) throws ClassNotFoundException, SQLException {

        //导入驱动jar包

        Class.forName("com.mysql.cj.jdbc.Driver");//注册驱动

        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");

        //定义sql语句
        String sql = "update stu set age = 66 where id = 1";

        //获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        //执行sql
        int count = stmt.executeUpdate(sql);

        //处理结束
        System.out.println(count);

        //释放资源
        stmt.close();
        conn.close();
    }
}
