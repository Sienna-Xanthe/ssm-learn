package com.itheima.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapperTest {

    /**
     * 查询一个具体的值
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession =sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟条件user
        User condition = new User();
        condition.setId(1);
        condition.setUsername("zhangsan");
        condition.setPassword("123");
        List<User> userList = mapper.findByCondition(condition);
        System.out.println(userList);

    }

    /**
     * 根据ids集合查询数据
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession =sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //模拟ids的数据
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);
    }

    /**
     * 插入数据将date数据类型的转换为毫秒存入数据库
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession =sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //创造user
         User user = new User();
         user.setUsername("Java");
         user.setPassword("12354");
         user.setBirthday(new Date());
        //执行保存操作
        mapper.save(user);

        sqlSession.close();


    }
    /**
     * 从数据库取出数据把毫秒类型转换为date类型
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession =sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user =mapper.findByid(130);
        System.out.println("user中的birthday: " + user.getBirthday());
        //类型自动转换为了date类型
        //输出：  user中的birthday: Thu Dec 02 16:48:20 CST 2021

        sqlSession.close();

    }

    /**
     * 查询全部并分页
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession =sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //设置分页相关参数   当前页+每页显示的条数
        PageHelper.startPage(1,3);

        List<User> userList = mapper.findAll();

        for(User user : userList){
            System.out.println(user);
        }

        //获得与分页相关的参数
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println("当前页：" + pageInfo.getPageNum());
        System.out.println("每页显示条数：" + pageInfo.getPageSize());
        System.out.println("总条数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("上一页：" + pageInfo.getPrePage());
        System.out.println("下一页：" + pageInfo.getNextPage());
        System.out.println("是否为第一个：" + pageInfo.isIsFirstPage());
        System.out.println("是否为最后一个：" + pageInfo.isIsLastPage());

        sqlSession.close();

    }

}
