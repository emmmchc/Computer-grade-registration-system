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
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<script type="text/javascript" src="js/signCheck.js" ></script>
</head>
<body>
	<form action="Sign" method="post" enctype="multipart/form-data" onSubmit="return check()">
		<fieldset>
			<legend>信息配置</legend>
			<table cellspacing="10px" cellpadding=""5px align="center">
				<tr>
					<td>学号：</td>
					<td>
						<input style="width: 230px" name="signNumber" readonly value="${sessionScope.student.studentNumber}"/>
					</td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td>
						<input style="width: 230px" name="signName" readonly value="${sessionScope.student.studentName}"/>
					</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>
						<input style="width: 230px" name="signSex" readonly value="${sessionScope.student.studentSex}"/>
					</td>
				</tr>
				<tr>
					<td>身份证号：</td>
					<td>
						<input style="width: 230px" id="signIdNumber" name="signIdNumber" type="text" />
					</td>
				</tr>
				<tr>
					<td>院系：</td>
					<td>
						<input style="width: 230px" name="signDepartment" readonly value="${sessionScope.student.studentDepartment}"/>
					</td>
				</tr>
				<tr>
					<td>考试地点：</td>
					<td>
						<select name="signSite" style="width: 150px;height: 25px">
							<option value="东校区">东校区</option>
							<option value="西校区">西校区</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label for="signLevel">报考级别: </label></td>
					<td>
					<select id="signLevel" name="signLevel">
						<option value="">---</option>
					</select>
					</td>
				</tr>
				<tr>
					<td><label for="signSubject">报考科目: </label></td>
					<td>
						<select id="signSubject" name="signSubject">
							<option value="">---</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>电话：</td>
					<td><input style="width: 230px"  type="tel" id="signPhone" name="signPhone" value="${sessionScope.student.studentPhone}"></td>
				</tr>
				<tr>
					<td>照片上传：</td>
					<td><input type="file" name="signPic"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input id="reset" type="reset" value="重置" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="sign" type="submit" value="报名" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<p id="des" style="color:red;">
							<c:if test="${sessionScope.signReslut == 'unknownError'}">报名失败，错误未知</c:if>
							<c:if test="${sessionScope.signReslut == 'nameExit'}">学号已存在</c:if>
						</p>
					</td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
<script type="text/javascript" src="js/二级联动.js" ></script>
</html>