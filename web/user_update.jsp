<%@ page import="com.situ.web.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: xuezihan123
  Date: 2022/7/21
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            User user = (User)request.getAttribute("user");
        %>
        <form action="<%=request.getContextPath()%>/user?method=selectById" method="post">
            <input type="hidden" name="id" value="<%=user.getId()%>"/>
            <input type="text" name="username" value="<%=user.getUsername()%>" />
            <input type="password" name="password" value="<%=user.getPassword()%>" />
            <input type="text" name="email" value="<%=user.getEmail()%>" />
            <input type="tel" name="tel" value="<%=user.getTel()%>" />
            <input type="submit" value="修改"/>

        </form>


</body>
</html>
