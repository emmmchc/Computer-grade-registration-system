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
	<title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
</head>

<body style="margin: 0px; padding: 0px;">
	<div style="float: left; margin-left: 15%; margin-top: 20px">
		<table id="collegeTable" border="1" cellpadding="5px" cellspacing="0" width="800">
			<tr style="background-color: gainsboro;">
				<th>序号</th>
				<th>院系名称</th>
				<th>管理员账号</th>
				<th>管理员密码</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${faculties}" var="f">
				<tr>
					<td>${f.id}</td>
					<td>${f.department}</td>
					<td>${f.name}</td>
					<td>${f.pwd}</td>
					<td>
						<a href="query?facultyName=${f.name}">编辑</a>&nbsp;
						<a href="delete?facultyName=${f.name}" onclick="javascript:return confirm('确定删除此记录？');">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<input id="addTr" type="button" onclick="location='./GetDepartments?from=addFaculty'" value="添加院系管理员" style="margin-top: 20px"/>
	</div>
</body>
</html>
