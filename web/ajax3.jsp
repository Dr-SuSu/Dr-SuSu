<%--
  Created by IntelliJ IDEA.
  User: xuezihan123
  Date: 2022/7/28
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<script src="<%=request.getContextPath()%>/static/jquery-2.1.4.js"></script>

        省份：<select id="provinceId">
                    <option>--请选择省份--</option>
             </select>
        城市：<select id="cityId">
                    <option>--请选择省份--</option>
             </select>
        区县：<select id="areaId">
                    <option>--请选择省份--</option>
             </select>
        <script>
            $(function(){


                $.post(
                    '<%=request.getContextPath()%>/ajax3?method=selectProvince',
                    function (jsonObj) {
                        console.log(jsonObj);
                        // [{id: 510000, province: '四川省'},{id: 520000, province: '贵州省'}]
                        /*for (var i = 0; i < jsonObj.length; i++) { }*/
                        $(jsonObj).each(function() {
                            // this : {id: 510000, province: '四川省'}
                            // <option value='510000'>四川省</option>
                            $('#provinceId').append('<option value="'+this.id+'">'+this.province+'</option>');
                        });
                    },
                    'json'
                );


                $('#provinceId').change(function() {
                    var provinceId = $('#provinceId').val();
                    $('cityId option:gt(0)').remove();//移除除第一行外的其他城市名
                    $.post(
                        '<%=request.getContextPath()%>/ajax3?method=selectCity',
                        {'provinceId' : provinceId},
                        function (jsonObj) {
                            console.log(jsonObj);
                            $(jsonObj).each(function() {
                                $('#cityId').append('<option value="'+this.id+'">'+this.city+'</option>');
                            });
                        },
                        'json'
                    );
                });








            });
        </script>
</body>
</html>
