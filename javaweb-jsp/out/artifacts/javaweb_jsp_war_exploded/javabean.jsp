<%@ page import="com.warren.pojo.People" %><%--
  Created by IntelliJ IDEA.
  User: wkj
  Date: 2020/4/10
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
//        People people = new People();
    %>

    <jsp:useBean id="people" class="com.warren.pojo.People" scope="page"></jsp:useBean>

<%--    <%people.setAddress();%>--%>
    <jsp:setProperty name="people" property="address" value="武汉"></jsp:setProperty>
    <jsp:setProperty name="people" property="name" value="warren"></jsp:setProperty>
    <jsp:setProperty name="people" property="age" value="22"></jsp:setProperty>
    <jsp:setProperty name="people" property="id" value="1"></jsp:setProperty>

<%--    <%=people.getAddress()%>--%>
    地址：<jsp:getProperty name="people" property="address"/>
    姓名：<jsp:getProperty name="people" property="name"/>
    年龄：<jsp:getProperty name="people" property="age"/>
    ID：<jsp:getProperty name="people" property="id"/>
</body>
</html>
