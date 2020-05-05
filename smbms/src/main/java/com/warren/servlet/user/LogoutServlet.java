package com.warren.servlet.user;

import com.warren.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //移除用户的Constants.USER_SESSION
        req.getSession().removeAttribute(Constants.USER_SESSION);
        //返回登录页面
        /*
        * login.jsp  ---> http://localhost:8080/smbms/jsp/login.jsp
        * /login.jsp ---> http://localhost:8080/login.jsp
        *
        * */
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
