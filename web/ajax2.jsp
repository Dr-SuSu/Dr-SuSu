<%--
  Created by IntelliJ IDEA.
  User: xuezihan123
  Date: 2022/7/27
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form >
    <input type="text" name="name" id="nameId"/><span id="spanNameId"></span><br/>
    <input type="password" name="password"/><span id="spanPasswordId"></span><br/>
    <input type="submit" value="登录"/>
</form>

<script src="<%=request.getContextPath()%>/static/jquery-2.1.4.js"></script>
<script>
    $(function() {
        $('#nameId').blur(function() {
            // this
            var name = $(this).val();
            $.post(
                '<%=request.getContextPath()%>/ajax2',
                {'name' : name},
                function(jsonObj) {
                    console.log(jsonObj);
                    // {exist: true, msg: '此用户已经存在，请更换一个'}
                    if (jsonObj.exist) {
                        $('#spanNameId').html(jsonObj.msg);
                        $('#spanNameId').css('color', 'red');
                    } else {
                        $('#spanNameId').html(jsonObj.msg);
                        $('#spanNameId').css('color', 'green');
                    }
                },
                'json'
            );
        });
    });
</script>
</body>
</html>
