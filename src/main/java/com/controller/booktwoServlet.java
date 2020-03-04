package com.controller;

import com.book.Book;
import com.book.BookDaoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/booktwo.do")
public class booktwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int bookno=Integer.valueOf(req.getParameter("bookno"));
        BookDaoImpl bookDao=new BookDaoImpl();
        Book b=bookDao.getBookById(bookno);
//        Book b=new Book(1, "1", "1", 1, 1);
//        StringBuffer sb=new StringBuffer("{");
//        if(b!=null){
//            sb.append("\"bookno\":").append("\""+b.getBookno()+"\"").append(",");
//            sb.append("\"name\":").append("\""+b.getName()+"\"").append(",");
//            sb.append("\"title\":").append("\""+b.getTitle()+"\"").append(",");
//            sb.append("\"price\":").append("\""+b.getPrice()+"\"").append(",");
//            sb.append("\"number\":").append("\""+b.getNumber()+"\"");
//        }
//        sb.append("}");

//        使用jackson来转换
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(b);
        System.out.println(json);
        resp.setContentType("text/json;charset=UTF-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
