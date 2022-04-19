package cn.itcast.web.request;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * 演示Request对象获取请求行数据
 */
@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求方式：GET
        String method = request.getMethod();
        System.out.println(method);
        //2.(*)获取虚拟目录：/day928_servlet_war_exploded
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3.获取Servlet路径：/RequestDemo1
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //4.获取get方式请求参数：name=hahaha
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //5.(*)获取请求URL：/day928_servlet_war_exploded/RequestDemo1
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);
        //6.获取协议及版本：HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //7.获取客户机的IP地址：0:0:0:0:0:0:0:1
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
