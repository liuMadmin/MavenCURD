<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/5/27
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="application/javascript"></script>
<html>
<head>
    <title>SuccessQuery</title>
    <script>
        function submitForm(inputSbq) {
            var form = inputSbq.parentNode;
            form.action="${pageContext.request.contextPath}/deleteUser";
            form.submit();
        }
    </script>
</head>
<body>
    <h1 style="text-align: center;color: green">登录成功</h1>
    <br>
    <form>
        <table align="center">
            <tr>
                <td>
                    <h1><a href="${pageContext.request.contextPath}/updateUser.jsp">添加</a></h1>
                </td>
            </tr>
        </table>
    </form>

        <table align="center" border="1" cellpadding="0" cellspacing="0" width="50%">
            <tr align="center">
                <td>id</td>
                <td>name</td>
                <td>pwd</td>
                <td>sex</td>
                <td>birthday</td>
                <td>address</td>
                <td>操作1</td>
                <td>操作2</td>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr align="center">
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.password}</td>
                    <td>${user.sex}</td>
                    <td>${user.birthday}</td>
                    <td>${user.address}</td>
                    <%--下面这2种写法 传递的参数在地址栏是可见的  不安全--%>
                    <%--<td><a href="${pageContext.request.contextPath}/deleteUser?id=${user.id}&userName=${user.name}">删除</a> </td>--%>
                    <%--<td><a href="javascript:window.location='${pageContext.request.contextPath}/deleteUser?id=${user.id}&userName=${user.name}'">删除</a></td>--%>
                    <%--这种可隐藏参数--%>
                    <!--<td><a href="delete.jsp?id=${user.id}&userName=${user.name}">删除</a></td>-->
                    <td>
                        <form id="deleteForm" method="post">
                            <input type="text" style="display: none" value="${user.id}" name="id">
                            <input type="text" style="display: none" value="${user.name}" name="name">
                            <input type="button" style="background-color: red" value="删除" onclick="submitForm(this)">
                        </form>
                    </td>
                    <td><a href="${pageContext.request.contextPath}/queryUserById.do?id=${user.id}">修改</a></td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>
