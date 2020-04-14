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
    <%--请求转发--%>
    <jsp:forward page="/jspTag2.jsp">
            <%--转发携带 参数--%>
            <jsp:param name="name" value="warren"/>
            <jsp:param name="age" value="22"/>
    </jsp:forward>

</body>
</html>
