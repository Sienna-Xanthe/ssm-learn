package com.itheima.web;

import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/userServlet")
public class UserServlet  extends HttpServlet{//
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext app = new FileSystemXmlApplicationContext("E:\\java_code\\springmvc_20211116\\itheima_spring_mvc11_16\\src\\main\\resources\\applicationContext.xml");
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }

//    public static void main(String[] args) {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
////        ApplicationContext app = new FileSystemXmlApplicationContext("E:\\java_code\\springmvc_20211116\\itheima_spring_mvc11_16\\src\\main\\resources\\applicationContext.xml");
//        UserService userService = app.getBean(UserService.class);
//        userService.save();
//    }
}
