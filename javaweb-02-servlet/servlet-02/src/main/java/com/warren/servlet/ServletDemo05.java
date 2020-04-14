package com.warren.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServletDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取上下文
        ServletContext context = this.getServletContext();
        //获取资源文件输入流
        InputStream is = context.getResourceAsStream("/WEB-INF/classes/db.properties");
        //新建资源文件并导入文件输入流
        Properties pro = new Properties();
        pro.load(is);
        //获取文件内容
        String user = pro.getProperty("username");
        String pwd = pro.getProperty("password");
        //利用response打印输出
        resp.getWriter().print(user + ":" + pwd);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}