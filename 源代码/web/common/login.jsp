<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
<head>
	<base href="<%=basePath%>">
	<title>用户登录</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link type="text/css" rel="styleSheet"  href="css/login.css" />
	<script type="text/javascript" src="js/loginCheck.js" ></script>
</head>

<body>
	<h2 style="color: red;text-align: center;padding-top: 4em">计算机等级考试报名系统</h2>
	<div class="login">
		<form id="iform" name="form1" action="CheckAccount" method="post" onSubmit="return check()">
			<table cellspacing="10px" cellpadding="5px" align="left">
				<tr>
					<td class="textColor">账号：</td>
					<td><input id="name" type="text" name="userName" onclick="hid()"/></td>
				</tr>
				<tr>
					<td class="textColor">密码：</td>
					<td><input id="pwd" type="password" name="userPwd" onclick="hid()"/></td>
				</tr>
				<tr>
					<td class="textColor">角色：</td>
					<td>
						<input type="radio" name="role" onclick="hid()" value="student" checked /><label class="textColor">学生</>
						<input type="radio" name="role" onclick="hid()" value="faculty" /><label class="textColor">院系</label>
						<input type="radio" name="role" onclick="hid()" value="admin" /><label class="textColor">系统</label>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input id="register" type="button" onclick="location='./GetDepartments?from=reg'" value="注册" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="login" type="submit"  value="登录" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<p id="err" class="textColor">
						<c:if test="${loginResult == 'nameError'}">账户不存在</c:if>
						<c:if test="${loginResult == 'pwdError'}">密码错误</c:if>
						</p>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
