package com.controller;

import com.newbook.Newbook;
import com.newbook.NewbookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/bookkind")
public class newbookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewbookDao newbookDao=new NewbookDao();
        List<Newbook> list=newbookDao.getNewBook();
        StringBuffer sb=new StringBuffer();
        for (Newbook nb:list){
            sb.append("<option value='"+nb.getId()+"'>"+nb.getName()+":类别"+nb.getKind()+"</option>");
        }
        resp.setContentType("text/json;charset=UTF-8");
        resp.getWriter().println(sb.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
