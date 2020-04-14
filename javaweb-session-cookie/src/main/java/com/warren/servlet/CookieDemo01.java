package com.warren.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//保存用户上一次访问的时间
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");

        PrintWriter out = resp.getWriter();

        //Cookie: 服务端从客户端获取到
        Cookie[] cookies = req.getCookies();
        //判断Cookie是否存在
        if (cookies != null){
            out.write("您上一次访问时间是：");
            for (int i = 0; i < cookies.length;i++){
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("lastLoginTime")){
                    //获取Cookie中的值
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }
            }
        }else{
            out.write("这是您第一次访问本站！");
        }

        //服务端给客户端响应一个Cookie
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        //有效期为1天
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
