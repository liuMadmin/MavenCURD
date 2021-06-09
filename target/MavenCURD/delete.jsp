    <%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/6/5
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<script type="application/javascript"></script>
<html>
<head>
    <title>Delete</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script>
        function onDelete() {
            var submitForm = $("#submitForm");
            submitForm.attr("action","${pageContext.request.contextPath}/deleteUser");
            submitForm.submit();
        }
    </script>
</head>
<body>
    <%
        request.setAttribute("id",request.getParameter("id"));
        request.setAttribute("name",request.getParameter("userName"));
    %>

    <form id="submitForm" method="post">
        id:<input type="text" id="id" name="sid" value="${id}"><br>
        name:<input type="text" id="name" name="name" value="${name}"><br>
        <input type="button" value="提交" onclick="onDelete()">
    </form>
</body>
</html>
