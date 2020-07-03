<%@page import="entity.Admin"%>
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

	<link type="text/css" rel="styleSheet"  href="css/faculty.css" />
	<script type="text/javascript" src="js/faculty.js" ></script>
</head>
	<body>
		<div class="title">
			<h2 align="center" class="pt textColor">计算机等级考试报名系统</h2>
		</div>
		<div class="left">
			<p id="manageSign" class="leftItem" onclick="show(1)">报名信息管理</p>
			<p id="searchSign" class="leftItem" onclick="show(2)">报名信息查询</p>
			<p id="changePwd" class="leftItem" onclick="show(3)">修改个人密码</p>
			<p id="logout" class="leftItem" onclick="location='./Exit?type=faculty'">安全退出系统</p>
		</div>
		<div class="right">
			<iframe id="myiframe" src="./PrintSign" class="miframe" frameborder="0"></iframe>
		</div>
  </body>
</html>
