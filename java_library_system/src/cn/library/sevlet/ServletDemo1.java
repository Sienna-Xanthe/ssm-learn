package cn.library.sevlet;

import cn.library.book.Book;
import cn.library.dao.BookDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletDemo")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
        String bk_name = request.getParameter("bk_name");
       Book chaxunbook = new Book();
        chaxunbook.setBk_name(bk_name);

       //BookDao dao = new BookDao();
       BookDao dao = new BookDao();
        List<Book> list = dao.chaxun(chaxunbook);


        if(list != null)
        {
            request.setAttribute("list",list);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }
        else{
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }


    }
}
