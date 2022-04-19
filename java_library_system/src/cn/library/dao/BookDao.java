package cn.library.dao;

import cn.library.book.Book;
import cn.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookDao {



    /**
     * 书名查询书籍
     */
    public List<Book> chaxun(Book chaxunbook){
       // Class.forName("com.mysql.cj.jdbc.Driver");
          JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String ssql = "select count(id) from book where bk_name like CONCAT('%',?,'%')";
        Long total = template.queryForObject(ssql,Long.class,chaxunbook.getBk_name());
        if(total == 0)
        {
            System.out.println("没有查询到此书，请检查您输入的书名是否正确！");
        }
        else {
            String sql1 = "select * from book where bk_name like CONCAT('%',?,'%')";
            List<Book> list = template.query(sql1, new BeanPropertyRowMapper<Book>(Book.class), chaxunbook.getBk_name());
//            for(Book book : list){
//                System.out.println(book);
//            }
            return list;
        }
       return null;
    }
}
