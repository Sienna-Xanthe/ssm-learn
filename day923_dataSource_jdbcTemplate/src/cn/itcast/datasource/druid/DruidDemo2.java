package cn.itcast.datasource.druid;

import cn.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */
public class DruidDemo2 {
    public static void main(String[] args)
    {
        /*
         *完成添加操作：给stu表添加一条记录
         */

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "insert into stu values(4,?,?,?,?,?)";
            //3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //4.给?赋值
            pstmt.setString(1,"张三");
            pstmt.setInt(2,88);
            pstmt.setDouble(3,44.6);
            pstmt.setString(4, "1999-9-9");
            pstmt.setString(5, "2021-09-22 18:46:54");
            //5.执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            JDBCUtils.close(null,pstmt,conn);
        }

    }
}
