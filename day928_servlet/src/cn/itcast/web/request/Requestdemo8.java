
package cn.itcast.web.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Requestdemo8")
public class Requestdemo8 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("demo8////////////");
      //转发到demo9资源
        request.getRequestDispatcher("/Requestdemo9").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        /*
        //根据参数名称获取数值
        String username = request.getParameter("username");
        System.out.println("post");
        System.out.println(username);*/

        this.doGet(request,response);


    }
}
