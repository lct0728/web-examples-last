package com.controller;

import com.city.City;
import com.city.CityDaoImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/city2.do")
public class citytwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pid=Integer.valueOf(req.getParameter("pid"));
        CityDaoImp cityDaoImp=new CityDaoImp();
        List<City> list=cityDaoImp.getCityByPid(pid);
        StringBuffer sb=new StringBuffer();
        for(City c:list){
            sb.append("<option value='"+c.getId()+"'>"+c.getName()+"</option>");
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println(sb.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
