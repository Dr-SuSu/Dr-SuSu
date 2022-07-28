<%@ page import="com.situ.web.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: xuezihan123
  Date: 2022/7/21
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/user" method="post">
    用户名：<input type="text" name="username"/><br />
    密码：<input type="text" name="password"/><br />
    邮箱：<input type="text" ame="email"/><br />
    电话：<input type="text" name="tel"/><br />
    <input type="hidden" name="method" value="addUser"/>
    <input type="submit" name="添加"/>
</form>
</body>
</html>
