package com.itheima.web;

import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext app = new FileSystemXmlApplicationContext("E:\\\\java_code\\\\itheima_spring_ioc_anno2\\\\src\\\\test\\\\resources\\\\applicationContext.xml");
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
