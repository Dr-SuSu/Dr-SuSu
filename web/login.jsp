<%--
  Created by IntelliJ IDEA.
  User: xuezihan123
  Date: 2022/7/25
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录界面</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/user?method=login" method="post">
    用户名：<input type="text" name="name"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="submit" name="登录"/>
</form>
</body>
</html>
