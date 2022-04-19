package cn.library.sevlet;

import cn.library.book.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> list = (List<Book>) request.getAttribute("list");
        if(list != null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("查询成功！<br>");
            for(Book book : list){
                response.getWriter().write("<tr><td>" + book.getId() + "</td><br>" +
                        "<tr><td>" + book.getBk_name() + "</td><br>" +
                        "<tr><td>" + book.getAuthor() + "</td><br>" +
                        "<tr><td>" + book.getPublish() + "</td></tr><br>");
                out.println("<tr><td>" + book.getId() + "</td>");
                out.println("<tr><td>" + book.getBk_name() + "</td>");
                out.println("<tr><td>" + book.getAuthor() + "</td>");
                out.println("<tr><td>" + book.getPublish() + "</td></tr>");
            }
        }
    }
}
