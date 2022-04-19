package cn.itcast.jdbctemplate;

import cn.itcast.domain.Emp;
import cn.itcast.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {


    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 修改1号数据的  salary 为 10000
     */
    @Test
    public void test1(){
        //1.获取JDBCTemplate对象

        //2.定义sql
        String sql = "update emp set salary = 10000 where id = 1001";
        int count = template.update(sql);
        System.out.println(count);

    }

    /**
     * 添加一条记录
     */
    @Test
    public void test2(){
        String sql = "insert into emp(id,ename,dept_id) values(?,?,?)";
        int count = template.update(sql,1015,"郭靖",10);
        System.out.println(count);
    }

    /**
     * 删除刚才添加的记录
     */
    @Test
    public void test3(){
        String sql = "delete from emp where id = ?";
        int count = template.update(sql,1015);
        System.out.println(count);
    }

    /**
     * 查询id为1的记录，将其封装为Map集合
     * 注意：这个方法查询的结果集长度只能是1
     */
    @Test
    public void test4(){
        String sql = "select * from emp where id = ? ";
        Map<String,Object> map = template.queryForMap(sql,1001);
        System.out.println(map);
        //{id=1001, ename=孙悟空, job_id=4, mgr=1004, joindate=2000-12-17, salary=10000.00, bonus=null, dept_id=20}
    }


    /**
     * 查询所有记录，将其封装为List
     */
    @Test
    public void test5(){
        String sql = "select * from emp ";
        List<Map<String,Object>> list = template.queryForList(sql);
        for (Map<String,Object> stringObjectMap : list){
            System.out.println(stringObjectMap);
        }
    }

    /**
     * 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void test6(){
        String sql = "select * from emp ";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list){
            System.out.println(emp);
        }
    }

    /**
     * 查询总记录数
     */
    @Test
    public void test7(){
        String sql = "select count(id) from emp ";
        Long total = template.queryForObject(sql,Long.class);
        System.out.println(total);//14
    }
}
