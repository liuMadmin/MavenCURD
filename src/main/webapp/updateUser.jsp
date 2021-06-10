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
        var str = '<img src="images/gou.png">';

        function updateForm(){
            var form = $("#updateForm");
            var url1 = "${pageContext.request.contextPath}/addUser.do";
            var url2 = "${pageContext.request.contextPath}/updateUser.do";
            form.attr("action",${user.id==null}?url1:url2);
            form.submit();
        }

        function checkAll(){
            return checkedUserName()&&checkPwd()&&checkAddress();
        }

        function checkPwd(){
            var checkPwdErr = $("#checkPwdErr");
            var pwd = $("#pwd").val();
            var regNull = /^\s*$/g;
            var str1 = '<font style="color: red">密码不能为空</font>';
            var str2 = '<font style="color: red">密码不能少于6位</font>';

            if (regNull.test(pwd)){
                checkPwdErr.html(str1);
                return false;
            } else if (pwd.length<6){
                checkPwdErr.html(str2);
                return false;
            } else {
                checkPwdErr.html(str);
                return true;
            }
        }

        function checkedUserName() {
            var userName = $("#userName").val();
            var userNameErr = $("#userNameErr");
            var regNull = /^\s*$/g;
            var str1 = '<font style="color: red">用户名不能为空</font>';

            if (regNull.test(userName)){
                userNameErr.html(str1);
                return false;
            }else {
                userNameErr.html(str);
                return true;
            }
        }

        function checkAddress() {
            var address = $("#address").val();
            var addressErr = $("#checkAddressErr");
            var regNull = /^\s*$/g;
            var str1 = '<font style="color: red">地址不能为空</font>';

            if (regNull.test(address)){
                addressErr.html(str1);
                return false;
            }else {
                addressErr.html(str);
                return true;
            }
        }

        function  checkUserName(userName) {
            var checkUN = $("#checkedUserName");
            var str1 = '<font style="color: red">用户名已注册不可用</font>';

            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/checkUserName.do",
                data: "userName="+userName+"&location=Boston",
                success: function(msg){
                    if (msg==1){                       //已有用户名
                        checkUN.html(str1);
                    }else {
                        checkUN.html(str);
                    }
                }
            });
        }
    </script>
</head>
<body>
    <form id="updateForm" method="post" onsubmit="return checkAll();">
        用户Id:${user.id}   用户名:${user.userName}<br>
        <%--id:--%><input type="text" style="display: none" name="id" value="${user.id}"><br>
        name:<input type="text" id="userName" name="userName" value="${user.userName}" onblur="checkedUserName()" onchange="checkUserName(this.value)">
        <span id="checkedUserName"></span>
        <span id="userNameErr"></span>
        <br>
        password:<input type="password" id="pwd" name="pwd" value="${user.pwd}" onblur="checkPwd()">
        <span id="checkPwdErr"></span>
        <br>
        sex:<input type="radio" name="sex" value="1"<c:if test="${user.sex==1}">checked</c:if> >男
            <input type="radio" name="sex" value="2"<c:if test="${user.sex==2}">checked</c:if>>女
            <input type="radio" name="sex" value="0"<c:if test="${user.sex==null}">checked</c:if>>未知
        <br>
        address:<input type="text" id="address" name="address" value="${user.address}" onblur="checkAddress()">
        <span id="checkAddressErr"></span>
        <br>
        <input type="button" value="提交" onclick="updateForm()">
    </form>
</body>
</html>
