<%--
  Created by IntelliJ IDEA.
  User: wkj
  Date: 2020/4/10
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jspTag</title>
</head>
<body>
    <h1>2</h1>

    <%--获取参数--%>
    名字：<%=request.getParameter("name")%>
    年龄：<%=request.getParameter("age")%>

</body>
</html>
