package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


//<bean id="userService" class="com.itheima.service.impl.UserServiceImpl">
//@Component("userService")
@Service("userService")//作用与Component一样，这样只是增强可读性
@Scope("prototype")//多个
//@Scope("singleton")//单个
public class UserServiceImpl implements UserService {

    @Value("com.mysql.cj.jdbc.Driver")
    private String driver;


//     <property name="userDao" ref="userDao"></property>
//   @Autowired//按照数据类型从Spring容器中进行匹配的
//   @Qualifier("userDao")//是按照id值从容器中进行匹配的，但是主要此处 @Qualifier 结合 @Autowired 一起使用

    @Resource(name = "userDao") // @Resource 相当于 @Qualifier + @Autowired
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void init(){
        System.out.println("Service对象初始化方法");
    }

    @PreDestroy
    public void destory(){
        System.out.println("Service对象销毁方法");
    }
}
