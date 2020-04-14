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
  <h1>当前有<span style="color: deeppink"><%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%></span>个人在线</h1>

  <%--我是JSP注释--%>
  <!--我是HTML注释-->
  </body>
</html>
