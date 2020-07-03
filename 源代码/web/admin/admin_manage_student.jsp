<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <base href="<%=basePath%>">
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<style type="text/css">
			.mTr:hover {
				background-color:#AAAAAB;
			}
			
			.mTd {
				text-align: center;
			}
	</style>
	<script type="text/javascript">
		function initTab(){
			var obj=document.getElementById("signTable");
			for(var i=0;i<obj.rows.length;i++){
				obj.rows[i].onmouseover=function(){this.style.background="pink";}
				obj.rows[i].onmouseout=function(){this.style.background="";}
			}
		}
	</script>
</head>
<body style="margin: 0px; padding: 0px;">
	<div style="padding-top: 50px"></div>
	<table id="studentTable" border="1" cellpadding="5px" cellspacing="0" width="800" align="center">
		<tr style="background-color: gainsboro;">
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>院系</th>
			<th>电话</th>
			<th>密码</th>
			<th>报名状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${page.list}" var="s">
			<tr>
				<td>${s.studentNumber}</td>
				<td>${s.studentName}</td>
				<td>${s.studentSex}</td>
				<td>${s.studentDepartment}</td>
				<td>${s.studentPhone}</td>
				<td>${s.studentPwd}</td>
				<td>${s.studentSign}</td>
				<td>
					<a href="query?studentNumber=${s.studentNumber}">编辑</a>&nbsp;
					<a href="delete?studentNumber=${s.studentNumber}" onclick="javascript:return confirm('确定删除此记录？');">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
<%--分页显示的开始 --%>
<div style="text-align:center">
	第${page.currentPageNum}页/共${page.totalPageNum}页

	<a href="${pageContext.request.contextPath}/${page.url}&num=1">首页</a>
	<a href="${pageContext.request.contextPath}/${page.url}&num=${page.prePageNum}">上一页</a>
	<%--显示的页码，使用forEach遍历显示的页面 --%>
	<c:forEach begin="${page.startPage}" end="${page.endPage}" var="pagenum">
		<a href="${pageContext.request.contextPath}/${page.url}&num=${pagenum}">${pagenum}</a>
	</c:forEach>

	<a href="${pageContext.request.contextPath}/${page.url}&num=${page.nextPageNum}">下一页</a>
	<a href="${pageContext.request.contextPath}/${page.url}&num=${page.totalPageNum}">末页</a>
	<input type="text" id="pagenum" name="pagenum" size="1"/><input type="button" value="前往" onclick="jump()" />
	<script type="text/javascript">
		function jump(){
			var totalpage = ${page.totalPageNum};
			var pagenum = document.getElementById("pagenum").value;
			//判断输入的是一个数字
			var reg =/^[1-9][0-9]{0,1}$/;
			if(!reg.test(pagenum)){
				//不是一个有效数字
				alert("请输入符合规定的数字");
				return ;
			}
			//判断输入的数字不能大于总页数
			if(parseInt(pagenum)>parseInt(totalpage)){
				//超过了总页数
				alert("不能大于总页数");
				return;
			}
			//转向分页显示的Servlet
			window.location.href="${pageContext.request.contextPath}/${page.url}&num="+pagenum;
		}
	</script>
</div>
<%--分页显示的结束--%>