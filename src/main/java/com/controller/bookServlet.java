package com.controller;



import com.book.BookDaoImpl;
import com.book.Book;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/book.do")
public class bookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookno=Integer.valueOf(req.getParameter("bookno"));
        BookDaoImpl bookDao=new BookDaoImpl();
        Book b=bookDao.getBookById(bookno);
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        if(b==null){
            out.println("书不存在");
        }else{
            out.println(bookno+"书存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
