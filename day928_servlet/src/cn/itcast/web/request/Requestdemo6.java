
package cn.itcast.web.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/Requestdemo6")
public class Requestdemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        //根据参数名称获取数值
        String username = request.getParameter("username");
        /*System.out.println("get");
        System.out.println(username);*/

        //根据参数名称获取参数值的数组
        /*
        String[] hobbies = request.getParameterValues("hobby");
        for(String hobby : hobbies){
            System.out.println(hobby);
        }*/

        //获取所有请求的参数名称
        /*
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
            System.out.println("-------------------");
        }*/

        //获取所有参数的map集合
        Map<String,String[]> parameterMap = request.getParameterMap();
        //遍历
        Set<String> keyset = parameterMap.keySet();
        for(String name : keyset){
            //获取键获取值
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for(String value : values)
            {
                System.out.println(value);
            }
            System.out.println("--------------------");
        }

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
