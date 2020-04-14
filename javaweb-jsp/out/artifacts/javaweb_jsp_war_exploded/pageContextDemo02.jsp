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
<%----%>
<%
    //通过application寻找
    //从底层到高层（作用域） :
    String name2 = (String) application.getAttribute("name2");
    String name3 = (String) application.getAttribute("name3");
    String name4 = (String) application.getAttribute("name4");
    String name5 = (String) application.getAttribute("name5");  //不存在
%>

<%--使用el表达式输出 ${} --%>

    <h1>Demo02取出的值为：</h1>

    <h1>取出的值为：</h1>
    <h3>request : ${name2}</h3>
    <h3>session : ${name3}</h3>
    <h3>application : ${name4}</h3>
    <h3>null : ${name5}</h3>
    null : <%=name5%>

</body>
</html>
