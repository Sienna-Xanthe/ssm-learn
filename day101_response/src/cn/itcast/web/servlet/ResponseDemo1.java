package cn.itcast.web.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("demo1.......");
/*
        //访问/responseDemo1，会自动跳转到/responseDemo2资源、
        //1.设置状态码为302
        response.setStatus(302);
        //2.设置响应头location
        response.setHeader("location","/day101/responseDemo2");*/

        //简单的重定向方法
        response.sendRedirect("/day101/responseDemo2");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
