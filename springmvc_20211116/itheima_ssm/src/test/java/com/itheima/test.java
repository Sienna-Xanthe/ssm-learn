package com.itheima;

import com.itheima.domain.Account;
import com.itheima.mapper.AccountMapper;
import com.itheima.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {

//    @Autowired
    private AccountMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(AccountMapper.class);
    }

//    @Autowired
//    private AccountService accountService;

    @Test
    public void test1(){
        List<Account> accountList = mapper.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }

    }

//    @Test
//    public void test2(){
//        List<Account> accountList = accountService.findAll();
//        for (Account account : accountList) {
//            System.out.println(account);
//        }
//    }

}
