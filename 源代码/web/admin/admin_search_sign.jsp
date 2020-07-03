<%@ page import="entity.Faculty"%>
<%@ page import="entity.Sign"%>
<%@ page import="java.util.List" %>
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

<body style="margin: 0px; padding: 0px;" onload="initTab();">
<div align="center">
    <form  method="post" action="condition">
        学号：<input type="text" name="sno"/>&nbsp;&nbsp;
        姓名：<input type="text" name="sname"/>&nbsp;&nbsp;
        <input type="submit"  value="模糊查询"/>
    </form>
</div>
<table id="signTable" border="1" cellpadding="5px" cellspacing="0" width="1400" align="center">
    <tr style="background-color: gainsboro;">
        <th>考生学号</th>
        <th>考生姓名</th>
        <th>考生性别</th>
        <th>身份证号</th>
        <th>所在院系</th>
        <th>考试地点</th>
        <th>考场号</th>
        <th>座位号</th>
        <th>准考证号</th>
        <th>考试等级</th>
        <th>考试科目</th>
        <th>考生电话</th>
        <th>考生照片</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${page.list}" var="s">
        <tr>
            <td>${s.signNumber}</td>
            <td>${s.signName}</td>
            <td>${s.signSex}</td>
            <td>${s.signIdNumber}</td>
            <td>${s.signDepartment}</td>
            <td>${s.signSite}</td>
            <td>${s.signRoom}</td>
            <td>${s.signSeat}</td>
            <td>${s.signExamNumber}</td>
            <td>${s.signLevel}</td>
            <td>${s.signSubject}</td>
            <td>${s.signPhone}</td>
            <td><img width="120" height="90" src="${s.signPic}"></td>
            <td>
                <a href="query?signNumber=${s.signNumber}">编辑</a>&nbsp;
                <a href="delete?signNumber=${s.signNumber}" onclick="javascript:return confirm('确定删除此记录？');">删除</a>
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
