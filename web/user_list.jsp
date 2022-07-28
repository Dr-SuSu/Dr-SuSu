<%--
  Created by IntelliJ IDEA.
  User: xuezihan123
  Date: 2022/7/26
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--<%
    List<Student> list = (List<Student>) request.getAttribute("list");
%>--%>
<%
    PageInfoPlus pageInfo = (PageInfoPlus) request.getAttribute("pageInfoPlus");
%>
<td><a href="student_add.jsp">添加</a></td>

<table class="table table-striped table-bordered table-hover table-condensed">

    <tr>
        <%--        <td>序号</td>--%>
        <td>ID</td>
        <td>名字</td>
        <td>年龄</td>
        <td>性别</td>
        <td>操作</td>
    </tr>
    <%
        for (Student student : pageInfo.getList()) {
    %>
    <tr>
        <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getAge()%></td>
        <td><%=student.getGender()%></td>
        <td><a href="<%=request.getContextPath()%>/student?method=deleteById&id=<%=student.getId()%>">删除</a></td>
        <td><a href="<%=request.getContextPath()%>/student?method=getStudentUpdatePage&id=<%=student.getId()%>">修改</a></td>
    </tr>

    <%
        }
    %>
</table>
<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="<%=request.getContextPath()%>/student?method=selectByPage&pageNo=<%=pageInfo.getPageNumber()-1%>" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <%
            for (int i = 1; i <= pageInfo.getTotalPage(); i++) {
        %>
        <li><a href="<%=request.getContextPath()%>/student?method=selectByPage&pageNo=<%=i%>"><%=i%></a></li>
        <%
            }
        %>

        <li>
            <a href="<%=request.getContextPath()%>/student?method=selectByPage&pageNo=<%=pageInfo.getPageNumber()+1%>" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
</body>
</html>
