<%--
  Created by IntelliJ IDEA.
  User: wkj
  Date: 2020/4/9
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp3</title>
</head>
<body>
    <%--@include会将两个页面合二为一--%>

    <%@include file="common/header.jsp"%>
    <h1>网页主体</h1>
    <%@include file="common/footer.jsp"%>
    <hr>

    <%--jsp标签
        jsp:include会拼接页面
    --%>
    <jsp:include page="common/header.jsp"></jsp:include>
    <h1>网页主体</h1>
    <jsp:include page="common/footer.jsp"></jsp:include>

</body>
</html>
