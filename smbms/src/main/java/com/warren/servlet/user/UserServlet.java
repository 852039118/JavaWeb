package com.warren.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;
import com.warren.pojo.User;
import com.warren.service.user.UserServiceImpl;
import com.warren.util.Constants;
import com.warren.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//实现Servlet复用
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method != null && method.equals("savepwd")){
            updatePwd(req,resp);
        }else if (method.equals("pwdmodify")){
            pwdModify(req,resp);
        }else if (method.equals("query")){
            query(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //修改新密码
    private void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);

        String newpassword = req.getParameter("newpassword");
        boolean flag = false;
        if ((o != null) && (!StringUtils.isNullOrEmpty(newpassword))){
            UserServiceImpl userService = new UserServiceImpl();
            flag = userService.updatePwd(((User) o).getId(), newpassword);
            if (flag){
                req.setAttribute("message","密码修改成功，请退出，用新密码登录！");
                //密码修改成功，移除当前Session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            }else{
                req.setAttribute("message","密码修改失败！");
            }
        }else{
            req.setAttribute("message","新密码有问题！");
        }
//        请求转发到当前页面
        req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
    }

    //验证旧密码，session中有用户的密码
    private void pwdModify(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldPassword = req.getParameter("oldpassword");   //获取到用户输入的密码

        Map<String, String> resultMap = new HashMap<String, String>();
        //验证输入的密码
        if ( o == null ){   //session过期了，失效了
            resultMap.put("result","sessionerror");
        }else if (StringUtils.isNullOrEmpty(oldPassword)) {  //用户输入的密码为空
            resultMap.put("result", "error");
        }else{//验证旧密码是否正确
            String userPassword = ((User) o).getUserPassword();  //获取到用户session密码
            if (userPassword.equals(oldPassword)){
                resultMap.put("result", "true");
            }else{
                resultMap.put("result", "false");
            }
        }
        resp.setContentType("application/json");
        PrintWriter outPrintWriter = resp.getWriter();
        //把resultMap以JSON方式响应给前端
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();
        outPrintWriter.close();
    }
    //用户管理
    private void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String queryName = req.getParameter("queryname");
        String role = req.getParameter("queryUserRole");
        int queryUserRole = 0;
        if (role != null & !role.equals("")){
            queryUserRole = Integer.parseInt(role);
        }

        PageSupport page = new PageSupport();
        page.setPageSize(5);

        UserServiceImpl userService = new UserServiceImpl();
        //总数量（表）
        int totalCount = userService.getUserCount(queryName, queryUserRole);



        resp.sendRedirect(req.getContextPath() + "/jsp/userlist.jsp");
    }
}



