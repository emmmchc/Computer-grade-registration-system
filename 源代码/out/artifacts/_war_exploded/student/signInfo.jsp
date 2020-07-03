<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎使用计算机等级考试报名系统</title>
    <script>
        function begin() {
            parent.window.document.getElementById("info").setAttribute("disabled","false");
            window.location = "known.jsp";
        }
    </script>
</head>
<body style="background: url(../img/library.jpg) no-repeat;background-size:100%;">
    <div style="height:auto;padding-top: 8em" align="center">
        <table style="background-color:#F9F9F9;box-shadow: 2px 2px 5px #ccc;border-radius: 3px;">
            <tr><td colspan="2" align="center">基本信息</td></tr>
            <tr>
                <td>考次名称：</td>
                <td>2020年09月计算机等级考试</td>
            </tr>
            <tr>
                <td>地点：</td>
                <td><strong style="color:red;">燕山大学</strong></td>
            </tr>
            <tr>
                <td>报名状态：</td>
                <td>
                    <c:if test="${sessionScope.student.studentSign == '未报名'}"><strong id="signState" style="color: red">未报名</strong></c:if>
                    <c:if test="${sessionScope.student.studentSign == '已报名'}"><strong id="signState" style="color: green">已报名</strong></c:if>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input id="startSign" type="button"  onclick="begin()" value="开始报名" /></td>
            </tr>
        </table>
    </div>
</body>
<script>
    var signState = document.getElementById("signState");
    if(signState.innerText == "已报名"){
        document.getElementById("startSign").disabled = true;
        parent.window.document.getElementById("mySign").setAttribute("disabled","false");
    }
</script>
</html>
