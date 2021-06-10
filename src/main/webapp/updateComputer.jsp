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
    <title>updateComputer and addComputer</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script>
        var str = '<img src="images/gou.png">';
        var str1 = '<font style="color: red">名称不能为空</font>';
        var str2 = '<font style="color: red">money不能为空</font>';
        var str3 = '<font style="color: red">money不能为负</font>';
        var str4 = '<font style="color: red">名称已被注册不可用</font>';

        var regNull = /^\s*$/g;

        function updateForm(){
            var form = $("#updateForm");
            var url1 = "${pageContext.request.contextPath}/addComputer.do";
            var url2 = "${pageContext.request.contextPath}/updateComputer.do";
            form.attr("action",${computer.id==null}?url1:url2);
            form.submit();
        }

        function checkedCName(cName){
            var checkedCName = $("#checkedCName");
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/checkComputerName.do",
                data: "cName="+cName+"&location=Boston",
                success: function(msg){
                    if (msg==1){                       //已有用户名
                        checkedCName.html(str4);
                    }else {
                        checkedCName.html(str);
                    }
                }
            });
        }

        function checkCName(){
            var cName = $("#cName").val();
            var checkCNameErr = $("#checkCNameErr");

            if (regNull.test(cName)){
                checkCNameErr.html(str1);
                return false;
            }else {
                checkCNameErr.html(str);
                return true;
            }
        }

        function checkMoney(){
            var money = $("#money").val();
            var checkMoneyErr = $("#checkMoneyErr");

            if (regNull.test(money)){
                checkMoneyErr.html(str2);
                return false;
            }if (money<0){
                checkMoneyErr.html(str3);
                return false;
            }else {
                checkMoneyErr.html(str);
                return true;
            }
        }

        function checkAll() {
            return checkCName()&&checkMoney();
        }
    </script>
</head>
<body>
    <form id="updateForm" method="post" onsubmit="return checkAll();">
        Id:${computer.id}   名:${computer.cName}<br>
        <%--id:--%><input type="text" style="display: none" name="id" value="${computer.id}"><br>
        cname:<input type="text" id="cName" name="cName" value="${computer.cName}" onblur="checkCName()" onchange="checkedCName(this.value)">
        <span id="checkedCName"></span>
        <span id="checkCNameErr"></span>
        <br>
        color:<input type="text" id="color" name="color" value="${computer.color}"><br>
        money:<input type="text" id="money" name="money" value="${computer.money}" onblur="checkMoney()">
        <span id="checkMoneyErr"></span>
        <br>
        <input type="button" value="提交" onclick="updateForm()">
    </form>
</body>
</html>
