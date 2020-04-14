<%--
  Created by IntelliJ IDEA.
  User: wkj
  Date: 2020/4/9
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--内置对象--%>
<%
    pageContext.setAttribute("name1","汪克俊");  //保存的数据只在一个页面中有效
    request.setAttribute("name2","warren");     //保存的数据只在一次请求中有效，请求转发会携带这个数据
    session.setAttribute("name3","wkj");        //保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
    application.setAttribute("name4","Hide on push");   //保存的数据只在服务器中有效，从打开服务器到关闭服务器
%>

<%----%>
<%
    //通过application寻找
    //从底层到高层（作用域）:  page -> request -> session -> application
    String name2 = (String) application.getAttribute("name2");
    String name3 = (String) application.getAttribute("name3");
    String name4 = (String) application.getAttribute("name4");
    String name5 = (String) application.getAttribute("name5");  //不存在
%>

<%--使用el表达式输出 ${} --%>

    <h1>Demo01取出的值为：</h1>
    <h3>name2 : ${name2}</h3>
    <h3>name3 : ${name3}</h3>
    <h3>name4 : ${name4}</h3>
    <h3>name5 : ${name5}</h3>
name5 : <%=name5%>
</body>
</html>
