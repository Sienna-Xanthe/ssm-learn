package com.itheima.web;

import com.itheima.config.SpringCofiguration;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
//        FileSystemXmlApplicationContext app = new FileSystemXmlApplicationContext("E:\\java_code\\itheima_spring_ioc_anno2\\src\\test\\resources\\applicationContext.xml");
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringCofiguration.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();

    }
}
