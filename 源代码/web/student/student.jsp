<%@page import="entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
<head>
    <base href="<%=basePath%>">
    <title>计算机等级考试报名系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">

	<link rel="stylesheet" type="text/css" href="css/student.css"/>
	<script type="text/javascript" src="js/student.js" ></script>
</head>

<body>
	<div class="title">
		<h2 align="center" class="pt textColor">计算机等级考试报名系统</h2>
	</div>
	<div class="left">
		<p id="info" class="leftItem" disabled="true" onclick="show(1)">考生须知</p>
		<p id="infoConfig" class="leftItem" disabled="true" onclick="show(2)">信息填写</p>
		<p id="mySign" class="leftItem" disabled="false" onclick="show(3)">我的报名</p>
		<p id="changePwd" class="leftItem" disabled="false" onclick="show(4)">修改密码</p>
		<p id="logout" class="leftItem" onclick="location='./Exit?type=student'">退出系统</p>
	</div>
	<div class="right">
		<iframe id="myiframe" src="student/signInfo.jsp?" class="miframe" frameborder="0"></iframe>
	</div>
</body>
</html>
