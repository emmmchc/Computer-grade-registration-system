<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form name="form2" action="AddFaculty" method="post" onSubmit="return check2()">
        <fieldset style="width: 315px; padding-top: 30px; padding-bottom: 30px;">
            <legend class="textColor" align="left">添加院系管理员</legend>
            <table cellspacing="10px" cellpadding=""5px align="center">
                <tr>
                    <td>院系：</td>
                    <td>
                        <select name="department" style="width: 150px;height: 25px">
                            <c:forEach items="${departments}" var="d">
                                <option>${d.department}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>姓名：</td>
                    <td><input style="width: 230px" id="name" type="text" onclick="hid()" name="name"></td>
                </tr>
                <tr>
                    <td class="textColor">密码：</td>
                    <td><input style="width: 230px" id="pwd" type="password" onclick="hid()" name="pwd"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="添加"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <p id="des" class="textColor">
                            <c:if test="${addFacultyResutl == 'failed'}">添加失败</c:if>
                            <c:if test="${addFacultyResult == 'nameExist'}">账户已存在</c:if>
                            <c:if test="${addFacultyResult == 'success'}">添加成功</c:if>
                        </p>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>
