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
<body>
	<div align="center">
		<table cellspacing="10px" cellpadding="10px">
			<tr>
				<td>你的照片</td>
				<c:if test="${sign.signPic != null}">
					<td><img width="120" height="80" src="${sign.signPic}"></td>
				</c:if>
			</tr>
			<tr>
				<td>考试等级</td>
				<c:if test="${sign.signLevel != null}">
					<td><strong style="color: red">${sign.signLevel}</strong><td>
				</c:if>
			</tr>
			<tr>
				<td>考试科目</td>
				<c:if test="${sign.signSubject != null}">
				<td><strong style="color: red">${sign.signSubject}</strong><td>
				</c:if>
			</tr>
			<tr>
				<td>考试地点</td>
				<c:if test="${sign.signSite != null}">
				<td><strong style="color: red">${sign.signSite}</strong><td>
				</c:if>
			</tr>
			<tr>
				<td>考场</td>
				<c:if test="${sign.signRoom != null}">
				<td><strong style="color: red">${sign.signRoom}</strong><td>
				</c:if>
			</tr>
			<tr>
				<td>座位</td>
				<c:if test="${sign.signSeat != null}">
				<td><strong style="color: red">${sign.signSeat}</strong><td>
				</c:if>
			</tr>
			<tr>
				<td>准考证号</td>
				<c:if test="${sign.signExamNumber != null}">
				<td><strong style="color: red">${sign.signExamNumber}</strong><td>
				</c:if>
			</tr>
			<tr>
				<td>你的学号</td>
				<c:if test="${sign.signNumber != null}">
				<td><strong style="color: red">${sign.signNumber}</strong><td>
				</c:if>
			</tr>
			<tr>
				<td>你的姓名</td>
				<c:if test="${sign.signName != null}">
				<td><strong style="color: red">${sign.signName}</strong><td>
				</c:if>
			</tr>
			<tr>
				<td>你的性别</td>
				<c:if test="${sign.signSex != null}">
				<td><strong style="color: red">${sign.signSex}</strong><td>
				</c:if>
			</tr>
			<tr>
				<td>联系方式</td>
				<c:if test="${sign.signPhone != null}">
				<td><strong style="color: red">${sign.signPhone}</strong><td>
				</c:if>
			</tr>
			<tr>
				<td>所在院系</td>
				<c:if test="${sign.signDepartment != null}">
				<td><strong style="color: red">${sign.signDepartment}</strong><td>
				</c:if>
			</tr>
			<tr>
				<td>身份证号</td>
				<c:if test="${sign.signIdNumber != null}">
				<td><strong style="color: red">${sign.signIdNumber}</strong><td>
				</c:if>
			</tr>
		</table>
	</div>
</body>
</html>
