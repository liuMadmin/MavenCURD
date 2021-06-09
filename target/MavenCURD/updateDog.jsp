<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/6/8
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="application/javascript"></script>
<html>
<head>
    <title>updateDog and addDog</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script>
        function updateForm(){
            var form = $("#updateForm");
            var url1 = "${pageContext.request.contextPath}/addDog.do";
            var url2 = "${pageContext.request.contextPath}/updateDog.do";
            form.attr("action",${dog.id==null}?url1:url2);
            form.submit();
        }
    </script>
</head>
<body>
    <form id="updateForm" method="post">
        Id:${dog.id}   名:${dog.dName}<br>
        <%--id:--%><input type="text" style="display: none" name="id" value="${dog.id}"><br>
        dname:<input type="text" name="dName" value="${dog.dName}"><br>
        health:<input type="text" name="health" value="${dog.health}"><br>
        strain:<input type="text" name="strain" value="${dog.strain}"><br>
        <input type="button" value="提交" onclick="updateForm()">
    </form>
</body>
</html>
