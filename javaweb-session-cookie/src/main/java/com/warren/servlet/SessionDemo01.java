package com.warren.servlet;

import com.warren.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        //得到Session
        HttpSession session = req.getSession();
        //Session中存东西
        session.setAttribute("name",new Person("汪克俊",22));
        //获取session的id
        String sessionId = session.getId();
        //判断Session是不是新创建的
        if(session.isNew()){
            resp.getWriter().write("Session创建成功，ID：" + sessionId);
        }else{
            resp.getWriter().write("Session已经在服务器中存在了，ID：" + sessionId);
        }

        //Session创建的时候做了什么事情
//        Cookie cookie = new Cookie("JSession", sessionId);
//        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
