<%@ page import="java.util.List" %>
<%@ page import="com.situ.web.pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: xuezihan123
  Date: 2022/7/28
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
        <%--往域对象中放值--%>
        <%
            pageContext.setAttribute("age", 18);
            pageContext.setAttribute("gender", "男");
        %>
        <c:set var="age" value="23" scope="page" ></c:set><%--scope:范围--%>
        ${age}<br/>

        <hr><br/>
        <%--2、条件判断--%>
        <%--EL还可以做判断--%>
        <c:if test="${gender=='男'}">
            男
        </c:if>
        <c:if test="${gender=='女'}">
            女
        </c:if>
        <hr><br/>
        <%--3、多条件判断--%>
        <c:set var="score" value="67"></c:set>
        <c:choose>
            <c:when test="${score >= 80 && score < 90}">
                优秀
            </c:when>
            <c:when test="${score >= 70 && score < 80}">
                良好
            </c:when>
            <c:when test="${score >= 60 && score < 70}">
                一般
            </c:when>
            <c:when test="${score >= 60 && score < 70}">
                可以
            </c:when>
        </c:choose>
        <hr><br/>
        <c:forEach begin="0" end="10" var="i" step="2">
            ${i}
        </c:forEach><br/>
        <hr><br/><%--遍历表--%>
        <%
            List<User> list1 = new ArrayList<>();
            list1.add(new User(1, "John", "John", "John", "John"));
            list1.add(new User(2, "", "John", "John", "John"));
            list1.add(new User(3, "John", "John", "John", "John"));
            request.setAttribute("list1", list1);
        %>
        <c:forEach items="${list1}" var="list"><%--要遍历的集合--%>
            ${list.username}--${list.password}--${list.email}--${list.tel}<br/>
        </c:forEach><br/>


        <%
            Map<String, String> map = new HashMap<>();
            map.put("name", "John");
            map.put("age", "15");
            request.setAttribute("map", map);
        %>
        <c:forEach items="${map}" var="map">
            ${map.key}--${map.value}<br/>
        </c:forEach><br/>


</body>
</html>
