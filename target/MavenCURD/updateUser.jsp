<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/6/8
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="application/javascript"></script>
<html>
<head>
    <title>updateUser And addUser</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script>
        function updateForm(){
            var form = $("#updateForm");
            var url1 = "${pageContext.request.contextPath}/addUser.do";
            var url2 = "${pageContext.request.contextPath}/updateUser.do";
            form.attr("action",${user.id==null}?url1:url2);
            form.submit();
        }
    </script>
</head>
<body>
    <form id="updateForm" method="post">
        用户Id:${user.id}   用户名:${user.userName}<br>
        <%--id:--%><input type="text" style="display: none" name="id" value="${user.id}"><br>
        name:<input type="text" name="userName" value="${user.userName}"><br>
        sex:<input type="radio" name="sex" value="1"<c:if test="${user.sex==1}">checked</c:if> >男
            <input type="radio" name="sex" value="2"<c:if test="${user.sex==2}">checked</c:if>>女
            <input type="radio" name="sex" value="0"<c:if test="${user.sex==0}">checked</c:if>>未知
        <br>
        address:<input type="text" name="address" value="${user.address}"><br>
        <input type="button" value="提交" onclick="updateForm()">
    </form>
</body>
</html>
