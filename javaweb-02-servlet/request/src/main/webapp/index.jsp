<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h1>Hello Word!</h1>
        <%--这里表单的意思是 以post的方式提交表单，提交到我们login请求--%>
        <form action="${pageContext.request.contextPath}/login" method="get">
            用户名：<input type="text" name="username"> <br>
            密码：<input type="password" name="password"> <br>
            爱好：
            <input type="checkbox" name="hobby">女孩
            <input type="checkbox" name="hobby">代码
            <input type="checkbox" name="hobby">唱歌
            <input type="checkbox" name="hobby">电影
            <input type="submit">
        </form>
</body>
</html>
