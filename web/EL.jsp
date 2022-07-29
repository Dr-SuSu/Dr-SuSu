<%@ page import="com.situ.web.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: xuezihan123
  Date: 2022/7/28
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL</title>
</head>
<body>
        <%
            //内置对象 ：
            //pageContext request response session application(ServletContext)
            //ServletContext application = new ServletContext();
            //pageContext.setAttribute();
            // 1 普通字符串
            pageContext.setAttribute("name", "zhangsan");
            request.setAttribute("name", "lisi");
            //User对象
            User user = new User(1, "zhangsan", "safdsg", "男", "sdfadg");
            session.setAttribute("user", user);
            //3.List<User>
            List<User> list = new ArrayList<User>();
            User
        %>
        <%--拿出普通字符串--%>
        1<%=request.getAttribute("name")%><br/><%--zhangsan--%>
        2<%=pageContext.getAttribute("name")%><br/><%--null--%>
        3<%=pageContext.findAttribute("name")%><br/><%--先去范围小的域对象找，再去范围大的域对象找--%>
        4${pageScope.name}<br/><%--lisi--%>
        5${requestScope.name}<br/>
        6${name}<br/>

        <%--Jsp表达式--%>
        <%
            User user1 = (User) session.getAttribute("user");
        %>
        <%--此处使用user1--%>
        <%=user1.getUsername()%><br/>
        <%=user1.getPassword()%><br/>

        <%--此处对应着EL  EL表达式--%>
        8${user.username}<br/>
        9${user.password}<br/>
        10${user.email}<br/>
        11${user.tel}<br/>

        <%--JSP表达式--%>
        <%
            List<User> userlist =(List<User>) application.getAttribute("list");
        %>
        <%=userlist.get(0).getUsername()%><br/>
        ${application.userlist}<br/>
        ${userlist[0].name}<br/>
</body>
</html>
