package com.spring.l05_web_admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// @WebServlet(urlPatterns = "/my_servlet")
public class MyServlet extends HttpServlet {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // super.doGet(req, resp); // 注释掉才可以显示页面
        // jdbcTemplate.queryForList("select * from user");
        Long aLong = jdbcTemplate.queryForObject("select count(*) from innodb_index_stats", Long.class);
        resp.getWriter().write(aLong.toString());
    }

}
