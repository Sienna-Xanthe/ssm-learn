package cn.itcast.web.request;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/Requestdemo5")
public class Requestdemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求消息--请求参数

        //1.请求字符流
        BufferedReader br = request.getReader();
        //2.读取数据
        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
    }
}
