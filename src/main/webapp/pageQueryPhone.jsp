<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/6/9
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="application/javascript"></script><html>
<head>
    <title>pageQueryPhone</title>
    <script>
        function submitForm(inputSbq) {
            var form = inputSbq.parentNode;
            form.action="${pageContext.request.contextPath}/deleteUser";
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
                    <h1><a href="${pageContext.request.contextPath}/updatePhone.jsp">添加</a></h1>
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
        <c:forEach items="${phones}" var="phone">
            <tr align="center">
                <td>${phone.id}</td>
                <td>${phone.pName}</td>
                <td>${phone.color}</td>
                <td>${phone.money}</td>
                <td>
                    <form id="deleteForm" method="post">
                        <input type="text" style="display: none" value="${phone.id}" name="id">
                        <input type="text" style="display: none" value="${phone.pName}" name="name">
                        <input type="button" style="background-color: red" value="删除" onclick="submitForm(this)">
                    </form>
                </td>
                <td><a href="${pageContext.request.contextPath}/queryPhoneById.do?id=${phone.id}">修改</a></td>
            </tr>
        </c:forEach>
    </table>

    <table align="center">
        <tr>
            <td>
                总共${totalCount}条数据&nbsp;&nbsp;&nbsp;
                当前第${pageNo}页&nbsp;&nbsp;&nbsp;
                总共${totalPageCount}页&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/pageQueryPhone.do?pageNo=1">首页</a>
                <c:if test="${pageNo>1}">
                    <a href="${pageContext.request.contextPath}/pageQueryPhone.do?pageNo=${pageNo-1}">上一页</a>
                </c:if>
                <c:if test="${pageNo<totalPageCount}">
                    <a href="${pageContext.request.contextPath}/pageQueryPhone.do?pageNo=${pageNo+1}">下一页</a>
                </c:if>
                <a href="${pageContext.request.contextPath}/pageQueryPhone.do?pageNo=${totalPageCount}">末页</a>
            </td>
        </tr>
    </table>
</body>
</html>
