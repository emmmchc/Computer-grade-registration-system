<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
<head>
	<base href="<%=basePath%>">
	<title>用户注册</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link type="text/css" rel="styleSheet" href="css/register.css" />
	<script type="text/javascript" src="js/registerCheck.js" ></script>
</head>

<body>
	<div align="center">
		<form name="form2" action="RegisterServlet" method="post" onSubmit="return check2()">
			<fieldset style="width: 315px; padding-top: 30px; padding-bottom: 30px;">
				<legend class="textColor" align="left">用户注册</legend>
				<table cellspacing="10px" cellpadding=""5px align="center">
					<tr>
						<td class="textColor">学号：</td>
						<td><input style="width: 230px" id="studentNumber" type="number" onclick="hid()" name="studentNumber"></td>
					</tr>
					<tr>
						<td class="textColor">姓名：</td>
						<td><input style="width: 230px" id="studentName" type="text" onclick="hid()" name="studentName"></td>
					</tr>
					<tr>
						<td class="textColor">性别：</td>
						<td>
							<input type="radio" name="studentSex" value="男" checked="true"><label class="textColor">男</label>
							<input type="radio" name="studentSex" value="女"><label class="textColor">女</label>
						</td>
					</tr>
					<tr>
						<td class="textColor">院系：</td>
						<td>
							<select name="studentDepartment" style="width: 150px;height: 25px">
								<c:forEach items="${departments}" var="d">
									<option>${d.department}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="textColor">电话：</td>
						<td><input style="width: 230px" id="studentPhone" type="tel" onclick="hid()" name="studentPhone"></td>
					</tr>
					<tr>
						<td class="textColor">密码：</td>
						<td><input style="width: 230px" id="studentPwd" type="password" onclick="hid()" name="studentPwd"></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input id="ret" type="button" onclick="location='common/login.jsp'" value="返回" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input id="reset" type="reset" value="重置" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input id="register" type="submit" value="注册" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<p id="des" class="textColor">
								<c:if test="${registerResutl == 'unknownError'}">注册失败，错误未知</c:if>
								<c:if test="${registerResult == 'nameExit'}">学号已存在</c:if>
								<c:if test="${registerResult == 'success'}">注册成功</c:if>
							</p>
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>
