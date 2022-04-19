package cn.library.jdbctemplate;

import cn.library.book.Book;
import cn.library.dao.BookDao;
import cn.library.student.Logquanbu;
import cn.library.student.Logs;
import cn.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateDemo1 {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
//    public static void main(String[] args)
//    {
//        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
//        String sql = "update book set status = '在架' where id = ?";
//        int count = template.update(sql,3);
//        System.out.println(count);
//    }

    @Test
    public void jieshu(){
        String bk_id = "3";
        String sql = "select * from book where id = ?";
        Book bk = template.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),bk_id);
        System.out.println(bk.toString());
        System.out.println("book name:" + bk.getBk_name());

    }

    @Test
    public void chakanjieyue(){
        String id = "1";
        String sql = "select bk_name,status,creact_time from logs where st_id = ? ";
        List<Logs> list = template.query(sql,new BeanPropertyRowMapper<Logs>(Logs.class),id);
        for(Logs logs : list){
            System.out.println(logs);
        }

    }

    @Test
    public void quanbuchaxun(){
        String sql = "select * from book";
        List<Book> list = template.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
        for(Book book : list){
            System.out.println(book);
        }
    }

    @Test
    public void bknamechaxun()
    {
        String bk_name = "的";
        String ssql = "select count(id) from book where bk_name like CONCAT('%',?,'%')";
        Long total = template.queryForObject(ssql,Long.class,bk_name);
        if(total == 0)
        {
            System.out.println("没有查询到此书，请检查您输入的书名是否正确！");
        }
        else {
            String sql1 = "select * from book where bk_name like CONCAT('%',?,'%')";
            List<Book> list = template.query(sql1, new BeanPropertyRowMapper<Book>(Book.class), bk_name);
            for(Book book : list){
                System.out.println(book);
            }
        }
    }

    @Test
    public void tianjiatushu()
    {
        String bk_name = "看见";
        String author = "柴静";
        String publish = "广西师范大学出版社";
        String ssql = "select count(id) from book where bk_name = ? and author = ? and publish = ?";
        Long total = template.queryForObject(ssql,Long.class,bk_name,author,publish);
        if(total > 0)
        {
            System.out.println("该书已经添加过！");
            //return 2;
        }
        else if(total == 0)
        {
            String sql1 = "insert into book(bk_name,author,publish,status) values(?,?,?,'在架')";
            int count = template.update(sql1,bk_name,author,publish);
            System.out.println("新增图书的记录数为：" + count);
            //return count;
        }
        //return 0;
    }

    @Test
    public void xiajiatushu()
    {
        String id = "15";
        String ssql = "select count(id) from book where id= ?";
        Long total = template.queryForObject(ssql,Long.class,id);
        if(total == 0)
        {
            System.out.println("未查询到该书！");
            //return 2;
        }
        else if(total == 1)
        {
            String sql1 = "delete from book where id = ?";
            int count = template.update(sql1,id);
            System.out.println("删除图书的记录数为：" + count);
            //return count;
        }

    }

    @Test
    public void gerenchaxun()
    {
        String id = "654";
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

    @Test
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

    @Test
    public void testcahxun(){
        Book chaxunbook = new Book();
        chaxunbook.setBk_name("小王子");
        BookDao dao = new BookDao();
        List<Book> list = dao.chaxun(chaxunbook);
        if(list != null){
            for(Book book : list){
                System.out.println(book);
            }
        }

    }



}
