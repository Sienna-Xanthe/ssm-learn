package cn.library.jdbctemplate;

import cn.library.book.Book;
import cn.library.student.Logs;
import cn.library.student.Student;
import cn.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;

public class studentjdbc {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 注册
     */
    public int zhuce(String name,String number,String phone){
        String sql = "insert into student(name,number,phone) values(?,?,?)";
        int count = template.update(sql,name,number,phone);
        System.out.println("注册数据条数为：" + count);
        return count;
    }

    /**
     * 学生登录：查询学生手机号和学号对应的记录数
     */
    public Long denglu(String number,String phone){
        String sql = "select count(id) from student where number = ? and phone = ?";
        Long count = template.queryForObject(sql,Long.class,number,phone);
        //String sql = "select count(id) from student ";
        //Long count = template.queryForObject(sql,Long.class);
        System.out.println("查询条数为：" + count);
        return count;
    }

    /**
     * 获取学生信息
     */
    public List<Student> stuid(String number){
        String sql = "select * from student where number = ?";
        List<Student> stu = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class),number);
//        for(Student student : stu){
//            System.out.println(student);
//        }
        return stu;
    }

    /**
     * 借书
     */
    public int jieshu(String bk_id,int stu_id){

        String ssql = "select count(id) from book where id = ?";
        Long total = template.queryForObject(ssql,Long.class,bk_id);
        if(total == 0)
        {
            System.out.println("没有查询到此书，请检查您输入的id是否正确！");
            return 4;
        }
        else {
            String sql1 = "select * from book where id = ?";
            Book bk = template.queryForObject(sql1,new BeanPropertyRowMapper<Book>(Book.class),bk_id);
            if(bk.getStatus().equals("在架"))
            {
                System.out.println("您要借的书是：" + bk.toString());
                String sql2 = "update book set status = '借出' where id = ?";
                int count1 = template.update(sql2,bk_id);
                System.out.println("借书更新数：" + count1);

                String sql3 = "insert into logs(st_id,bk_id,bk_name,status) values(?,?,?,?)";
                int count2 = template.update(sql3,stu_id,bk_id,bk.getBk_name(),"借书");
                System.out.println("个人添加借书记录数:" + count2);

                return 1;
            }
            else if(bk.getStatus().equals("借出")){
                System.out.println("您想要借的书《" + bk.getBk_name() + "》已被借出！");
                return 2;
            }
            else{
                System.out.println("状态错误！");
                return 3;
            }
        }


    }

    /**
     * 还书
     */
    public int huanshu(String bk_id,int stu_id){

        String ssql = "select count(id) from book where id = ?";
        Long total = template.queryForObject(ssql,Long.class,bk_id);
        if(total == 0)
        {
            System.out.println("没有查询到此书，请检查您输入的id是否正确！");
            return 4;
        }
        else {
            String sql1 = "select * from book where id = ?";
            Book bk = template.queryForObject(sql1,new BeanPropertyRowMapper<Book>(Book.class),bk_id);
            if(bk.getStatus().equals("借出"))
            {
                System.out.println("您要还的书是：" + bk.toString());
                String sql2 = "update book set status = '在架' where id = ?";
                int count1 = template.update(sql2,bk_id);
                System.out.println("还书更新数：" + count1);

                String sql3 = "insert into logs(st_id,bk_id,bk_name,status) values(?,?,?,?)";
                int count2 = template.update(sql3,stu_id,bk_id,bk.getBk_name(),"还书");
                System.out.println("个人添加还书记录数:" + count2);

                return 1;
            }
            else if(bk.getStatus().equals("在架")){
                System.out.println("您想要还的书《" + bk.getBk_name() + "》已还，请查看您输入的id是否正确！");
                return 2;
            }
            else{
                System.out.println("状态错误！");
                return 3;
            }
        }


    }

    /**
     * 查看个人借阅历史
     */
    public void chakanjieyue(int id){
        String sql = "select bk_name,status,creact_time from logs where st_id = ? ";
        List<Logs> list = template.query(sql,new BeanPropertyRowMapper<Logs>(Logs.class),id);
        for(Logs logs : list){
            System.out.println(logs);
        }

    }

    /**
     * 书籍全部查询
     */
    public void quanbuchaxun(){
        String sql = "select * from book";
        List<Book> list = template.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
        for(Book book : list){
            System.out.println(book);
        }
    }

    /**
     * 书的id查询
     */
    public void idchaxun(String bk_id){
        String ssql = "select count(id) from book where id = ?";
        Long total = template.queryForObject(ssql,Long.class,bk_id);
        if(total == 0)
        {
            System.out.println("没有查询到此书，请检查您输入的id是否正确！");
        }
        else {
            String sql1 = "select * from book where id = ?";
            Book bk = template.queryForObject(sql1, new BeanPropertyRowMapper<Book>(Book.class), bk_id);
            System.out.println(bk.toString());
        }
    }

    /**
     * 书名模糊查询
     */
    public List<Book> bknamechaxun(String bk_name)
    {
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
            return list;
        }
        return null;
    }

    /**
     * 作者模糊查询
     */
    public void authorchaxun(String author)
    {
        String ssql = "select count(id) from book where author like CONCAT('%',?,'%')";
        Long total = template.queryForObject(ssql,Long.class,author);
        if(total == 0)
        {
            System.out.println("没有查询到该作者的书，请检查您输入的名字是否正确！");
        }
        else {
            String sql1 = "select * from book where author like CONCAT('%',?,'%')";
            List<Book> list = template.query(sql1, new BeanPropertyRowMapper<Book>(Book.class), author);
            for(Book book : list){
                System.out.println(book);
            }
        }
    }

}
