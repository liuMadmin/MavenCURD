<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/6/8
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="application/javascript"></script>
<html>
<head>
    <title>updatePhone and addPhone</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script>
        function updateForm(){
            var form = $("#updateForm");
            var url1 = "${pageContext.request.contextPath}/addPhone.do";
            var url2 = "${pageContext.request.contextPath}/updatePhone.do";
            form.attr("action",${phone.id==null}?url1:url2);
            form.submit();
        }
    </script>
</head>
<body>
    <form id="updateForm" method="post">
        Id:${phone.id}   名:${phone.pName}<br>
        <%--id:--%><input type="text" style="display: none" name="id" value="${phone.id}"><br>
        pname:<input type="text" name="pName" value="${phone.pName}"><br>
        color:<input type="text" name="color" value="${phone.color}"><br>
        money:<input type="text" name="money" value="${phone.money}"><br>
        <input type="button" value="提交" onclick="updateForm()">
    </form>
</body>
</html>
