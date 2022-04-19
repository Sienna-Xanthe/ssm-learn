package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//<bean id="userDao" class="com.itheima.dao.impl.UserDaoImpl"></bean>
//@Component("userDao")
@Repository("userDao")//作用与Component一样，这样只是增强可读性
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running.....");
    }
}
