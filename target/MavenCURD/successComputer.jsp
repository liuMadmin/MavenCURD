<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/6/1
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="application/javascript"></script>
<html>
<head>
    <title>successComputerQuery</title>
    <script>
        function submitForm(inputSbq) {
            var form = inputSbq.parentNode;
            form.action="${pageContext.request.contextPath}/deleteComputer";
            form.submit();
        }
    </script>
</head>
<body>
    <h1 style="text-align: center;color: green">查找成功</h1>
    <br>
    <form>
        <table align="center">
            <tr>
                <td>
                    <h1><a href="${pageContext.request.contextPath}/updateComputer.jsp">添加</a></h1>
                </td>
            </tr>
        </table>
    </form>
    <table align="center" border="1" cellpadding="0" cellspacing="0" width="50%">
        <tr align="center">
            <td>id</td>
            <td>name</td>
            <td>color</td>
            <td>money</td>
            <td>操作1</td>
            <td>操作2</td>
        </tr>
        <c:forEach items="${Computers}" var="computer">
            <tr align="center">
                <td>${computer.id}</td>
                <td>${computer.cName}</td>
                <td>${computer.color}</td>
                <td>${computer.money}</td>
                <td>
                    <form id="deleteForm" method="post">
                        <input type="text" style="display: none" value="${computer.id}" name="id">
                        <input type="text" style="display: none" value="${computer.cName}" name="name">
                        <input type="button" style="background-color: red" value="删除" onclick="submitForm(this)">
                    </form>
                </td>
                <td><a href="${pageContext.request.contextPath}/queryComputerById.do?id=${computer.id}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
