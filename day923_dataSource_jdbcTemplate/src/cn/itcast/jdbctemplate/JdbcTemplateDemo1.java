package cn.itcast.jdbctemplate;

import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *JdbcTemplate入门
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args){
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //调用方法
        String sql = "update stu set age = 100 where id = ?";
        int count = template.update(sql,4);
        System.out.println(count);
    }
}
