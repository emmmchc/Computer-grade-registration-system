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
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<script type="text/javascript" src="js/admin.js" ></script>
</head>
<body style="text-align: center;">
	<div style="width:350px; margin-left: 35%">
		<table cellspacing="10px" cellpadding="10px">
			<tr>
				<td align="right">账号：</td>
				<td><input id="name" type="text" disabled="false" value="${sessionScope.admin.name}"/></td>
			</tr>
			<tr>
				<td align="right">原密码：</td>
				<td><input type="password" id="oldPwd" onclick="hid()" /></td>
			</tr>
			<tr>
				<td align="right">输入新密码：</td>
				<td><input type="password" id="newPwd" onclick="hid()" /></td>
			</tr>
			<tr>
				<td align="right">确认新密码：</td>
				<td><input type="password" id="newPwd2" onclick="hid()" /></td>
			</tr>
			<tr>
				<td><p id="des" style="color: red"></p></td>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<td><button id="okBtn" style="width: 60px; cursor: pointer;" onclick="return check()">确定</button></td>
			</tr>
		</table>
	</div>
</body>
</html>
