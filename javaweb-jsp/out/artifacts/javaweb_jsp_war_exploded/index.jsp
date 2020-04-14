<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: wkj
  Date: 2020/4/9
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <% Date date = new Date(); %>
  <%=date%>
  <% for (int i = 0 ; i < 5 ; i++){ %>
    <h1>hello,warren </h1><%=name%>
  <%   } %>

  <%!
    static private String name = "warren";
    public void getName(){

    }
  %>

  <%--我是JSP注释--%>
  <!--我是HTML注释-->
  </body>
</html>
