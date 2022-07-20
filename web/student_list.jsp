<%@ page import="java.util.List" import="com.situ.web.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: xuezihan123
  Date: 2022/7/20
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/bootstrap-3.4.1-dist/css/bootstrap.css">
</head>
<body>

<%--${list}--%>

<%
    List<Student> list = (List<Student>) request.getAttribute("list");
%>



<table class="table table-striped table-bordered table-hover table-condensed">

    <tr>
        <td>ID</td>
        <td>名字</td>
        <td>年龄</td>
        <td>性别</td>
        <td>删除</td>
    </tr>
    <%
        for (Student student : list) {
    %>
    <tr>
        <td>学号：<%=student.getId()%></td>
        <td>姓名：<%=student.getName()%></td>
        <td>年龄：<%=student.getAge()%></td>
        <td>性别：<%=student.getGender()%></td>
        <td><a href="">删除</a></td>
    </tr>


    <%
        }
    %>

</table>
</body>
</html>
