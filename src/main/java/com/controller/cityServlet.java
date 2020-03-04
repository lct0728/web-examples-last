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
@WebServlet("/city.do")
public class cityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pid=Integer.valueOf(req.getParameter("pid"));
        CityDaoImp cityDaoImp=new CityDaoImp();
        List<City> list=cityDaoImp.getCityByPid(pid);
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(list);
        System.out.println(json);
        resp.setContentType("text/json;charset=UTF-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
