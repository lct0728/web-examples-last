package com.controller;

import com.book.Book;
import com.book.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookpage.do")
public class bookpageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo=Integer.valueOf(req.getParameter("pageNo"));
        BookDaoImpl bookDao=new BookDaoImpl();
        List<Book> list=bookDao.getBooksForPage(pageNo);
        //在servlet里面返回一个table的html片段
        req.setAttribute("list", list);
        req.getRequestDispatcher("/subList.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
