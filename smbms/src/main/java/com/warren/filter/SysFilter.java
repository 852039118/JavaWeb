package com.warren.filter;

import com.warren.pojo.User;
import com.warren.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       HttpServletRequest request = (HttpServletRequest) servletRequest;
       HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取session
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);

        if (user == null){  //已经被移除或者注销了，或者未登录
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }else{
            filterChain.doFilter(request,response);
        }
    }

    public void destroy() {

    }
}
