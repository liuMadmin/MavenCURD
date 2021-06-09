<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/5/27
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/loginUser.do" method="post">
        用户名：<input type="text" id="userName" name="userName"/>
        <br>
        密     码：<input type="password" id="pwd" name="pwd"/>
        <br>
        <input type="submit" value="登录" />
    </form>
    <br>

    <form action="${pageContext.request.contextPath}/loginDog.do" method="post">
        用户名：<input type="text" id="dogName" name="dogName"/>
        <br>
        <input type="submit" value="查询" />
    </form>
    <br>

    <form action="${pageContext.request.contextPath}/loginPhone.do" method="post">
        用户名：<input type="text" id="phoneName" name="phoneName"/>
        <br>
        <input type="submit" value="查询" />
    </form>
    <br>

    <form action="${pageContext.request.contextPath}/loginComputer.do" method="post">
        用户名：<input type="text" id="cName" name="cName"/>
        <br>
        <input type="submit" value="查询" />
    </form>
</body>
</html>
