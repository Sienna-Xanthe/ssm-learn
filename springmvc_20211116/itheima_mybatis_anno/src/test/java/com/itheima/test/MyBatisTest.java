package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("tom");
        user.setPassword("abc");
        mapper.save(user);
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(132);
        user.setUsername("adsfsdhaha");
        user.setPassword("123");
        mapper.update(user);
    }
    @Test
    public void testdelete(){
        mapper.delete(131);
    }

    @Test
    public void testfindById(){
        User user = mapper.findById(131);
        System.out.println(user);
    }

    @Test
    public void testfindAll(){
        List<User> user = mapper.findAll();
        System.out.println(user);
    }
}
