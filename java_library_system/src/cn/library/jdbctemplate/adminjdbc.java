package cn.library.jdbctemplate;

import cn.library.student.Logquanbu;
import cn.library.student.Logs;
import cn.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class adminjdbc {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 管理登录：查询学生手机号和学号对应的记录数
     */
    public Long addenglu(String user_name,String secret){
        String sql = "select count(id) from admin where user_name = ? and secret = ?";
        Long count = template.queryForObject(sql,Long.class,user_name,secret);
        System.out.println("查询条数为：" + count);
        return count;
    }

    /**
     * 添加图书
     */
    public int tianjiatushu(String bk_name,String author,String publish)
    {
        String ssql = "select count(id) from book where bk_name = ? and author = ? and publish = ?";
        Long total = template.queryForObject(ssql,Long.class,bk_name,author,publish);
        if(total > 0)
        {
            System.out.println("该书已经添加过！");
            return 2;
        }
        else if(total == 0)
        {
            String sql1 = "insert into book(bk_name,author,publish,status) values(?,?,?,'在架')";
            int count = template.update(sql1,bk_name,author,publish);
            System.out.println("新增图书的记录数为：" + count);
            return count;
        }
        return 0;
    }

    /**
     * 下架图书
     */
    public int xiajiatushu(String id)
    {
        String ssql = "select count(id) from book where id= ?";
        Long total = template.queryForObject(ssql,Long.class,id);
        if(total == 0)
        {
            System.out.println("未查询到该书！");
            return 0;
        }
        else if(total == 1)
        {
            String sql1 = "delete from book where id = ?";
            int count = template.update(sql1,id);
            System.out.println("删除图书的记录数为：" + count);
            return count;
        }
        return 0;
    }

    /**
     * 个人查询
     */
    public void gerenchaxun(String id)
    {
        String sql = "select bk_name,status,creact_time from logs where st_id = ? ";
        List<Logs> list = template.query(sql,new BeanPropertyRowMapper<Logs>(Logs.class),id);
        if(list.size() == 0)
        {
            System.out.println("未查询到该用户！");
        }
        else{
            for(Logs logs : list){
                System.out.println(logs);
            }
        }


    }

    /**
     * 全部查询
     */
    public void jiluquanbuchaxun()
    {
        String sql = "select st_id,bk_id, bk_name,status,creact_time from logs ";
        List<Logquanbu> list = template.query(sql,new BeanPropertyRowMapper<Logquanbu>(Logquanbu.class));
        if(list.size() == 0)
        {
            System.out.println("未查询到记录！");
        }
        else{
            for(Logquanbu logquanbu : list){
                System.out.println(logquanbu);
            }
        }
    }
}
