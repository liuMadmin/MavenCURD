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
    <title>updatePhone and addPhone</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script>
        var str = '<img src="images/gou.png">';
        var str1 = '<font style="color: red">名称不能为空</font>';
        var str2 = '<font style="color: red">颜色不能为空</font>';
        var str3 = '<font style="color: red">名称已被注册不可用</font>';

        var regNull = /^\s*$/g;

        function updateForm(){
            var form = $("#updateForm");
            var url1 = "${pageContext.request.contextPath}/addPhone.do";
            var url2 = "${pageContext.request.contextPath}/updatePhone.do";
            form.attr("action",${phone.id==null}?url1:url2);
            form.submit();
        }

        function checkedPName(pName){
            var checkedPName = $("#checkedPName");
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/checkPhoneName.do",
                data: "pName="+pName+"&location=Boston",
                success: function(msg){
                    if (msg==1){                       //已有用户名
                        checkedPName.html(str3);
                    }else {
                        checkedPName.html(str);
                    }
                }
            });
        }

        function checkPName(){
            var pName = $("#pName").val();
            var checkPNameErr = $("#checkPNameErr");

            if (regNull.test(pName)){
                checkPNameErr.html(str1);
                return false;
            }else {
                checkPNameErr.html(str);
                return true;
            }
        }

        function checkColor(){
            var color = $("#color").val();
            var checkColorErr = $("#checkColorErr");

            if (regNull.test(color)){
                checkColorErr.html(str2);
                return false;
            }else {
                checkColorErr.html(str);
                return true;
            }
        }

        function checkAll() {
            return checkPName()&&checkColor();
        }
    </script>
</head>
<body>
    <form id="updateForm" method="post" onsubmit="return checkAll();">
        Id:${phone.id}   名:${phone.pName}<br>
        <%--id:--%><input type="text" style="display: none" name="id" value="${phone.id}" ><br>
        pname:<input type="text" id="pName" name="pName" value="${phone.pName}" onblur="checkPName()" onchange="checkedPName(this.value)">
        <span id="checkedPName"></span>
        <span id="checkPNameErr"></span>
        <br>
        color:<input type="text" id="color" name="color" value="${phone.color}" onblur="checkColor()">
        <span id="checkColorErr"></span>
        <br>
        money:<input type="text" id="money" name="money" value="${phone.money}"><br>
        <input type="button" value="提交" onclick="updateForm()">
    </form>
</body>
</html>
