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
        var str = '<img src="images/gou.png">';
        var str1 = '<font style="color: red">名称不能为空</font>';
        var str2 = '<font style="color: red">health不能为空</font>';
        var str3 = '<font style="color: red">品种不能为空</font>';
        var str4 = '<font style="color: red">名称已被注册不可用</font>';
        var str5 = '<font style="color: red">health只能在0~100之间</font>';

        var regNull = /^\s*$/g;

        function updateForm(){
            var form = $("#updateForm");
            var url1 = "${pageContext.request.contextPath}/addDog.do";
            var url2 = "${pageContext.request.contextPath}/updateDog.do";
            form.attr("action",${dog.id==null}?url1:url2);
            form.submit();
        }

        function checkedDName(dName){
            var checkedDName = $("#checkedDName");
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/checkDogName.do",
                data: "dName="+dName+"&location=Boston",
                success: function(msg){
                    if (msg==1){                       //已有用户名
                        checkedDName.html(str4);
                    }else {
                        checkedDName.html(str);
                    }
                }
            });
        }

        function checkDName(){
            var dName = $("#dName").val();
            var checkDNameErr = $("#checkDNameErr");

            if (regNull.test(dName)){
                checkDNameErr.html(str1);
                return false;
            }else {
                checkDNameErr.html(str);
                return true;
            }
        }

        function checkHealth(){
            var health = $("#health").val();
            var checkHealthErr = $("#checkHealthErr");

            if (regNull.test(health)){
                checkHealthErr.html(str2);
                return false;
            }if (health<0||health>100){
                checkHealthErr.html(str5);
                return false;
            }else {
                checkHealthErr.html(str);
                return true;
            }
        }

        function checkStrain(){
            var strain = $("#strain").val();
            var checkStrainErr = $("#checkStrainErr");

            if (regNull.test(strain)){
                checkStrainErr.html(str3);
                return false;
            }else {
                checkStrainErr.html(str);
                return true;
            }
        }

        function checkAll() {
            return checkDName()&&checkHealth()&&checkStrain();
        }
    </script>
</head>
<body>
    <form id="updateForm" method="post" onsubmit="return checkAll();">
        Id:${dog.id}   名:${dog.dName}<br>
        <%--id:--%><input type="text" style="display: none" name="id" value="${dog.id}"><br>
        dname:<input type="text" id="dName" name="dName" value="${dog.dName}" onblur="checkDName()" onchange="checkedDName(this.value)">
        <span id="checkedDName"></span>
        <span id="checkDNameErr"></span>
        <br>
        health:<input type="text" id="health" name="health" value="${dog.health}" onblur="checkHealth()">
        <span id="checkHealthErr"></span>
        <br>
        strain:<input type="text" id="strain" name="strain" value="${dog.strain}" onblur="checkStrain()">
        <span id="checkStrainErr"></span>
        <br>
        <input type="button" value="提交" onclick="updateForm()">
    </form>
</body>
</html>
