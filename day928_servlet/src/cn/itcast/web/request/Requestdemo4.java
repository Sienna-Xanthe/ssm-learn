package cn.itcast.web.request;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/Requestdemo4")
public class Requestdemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据：referer

        String referer = request.getHeader("referer");
        System.out.println(referer);

        //防盗链
        if(referer != null){
            if(referer.contains("/login.html")){
                //正常访问
                //System.out.println("播放..");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放..");
            }else{
                //盗链
                //System.out.println("来优酷吧...");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("来优酷吧...");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
