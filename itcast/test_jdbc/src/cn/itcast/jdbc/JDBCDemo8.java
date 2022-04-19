package cn.itcast.jdbc;

import cn.iscast.domain.Emp;
import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 */
public class JDBCDemo8 {
    public static void main(String[] args){
        List<Emp> list = new JDBCDemo8().findall2();
        System.out.println(list);
        System.out.println(list.size());
    }


    public List<Emp> findall2(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Emp> list = null;
        try {

            conn = JDBCUtils.getConnection();

            String sql = "select * from emp";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            Emp emp = null;
            list = new ArrayList<Emp>();
            while (rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus =rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                list.add(emp);



            }

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

            JDBCUtils.close(rs,stmt,conn);
//            if(rs !=null){
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(stmt !=null){
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(conn !=null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
        }


        return list;
    }


    public List<Emp> findall(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

                List<Emp> list = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

             conn = DriverManager.getConnection("jdbc:mysql:///db1","root","root");

            String sql = "select * from emp";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            Emp emp = null;
            list = new ArrayList<Emp>();
            while (rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus =rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                list.add(emp);



            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stmt !=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn !=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return list;
    }
}
