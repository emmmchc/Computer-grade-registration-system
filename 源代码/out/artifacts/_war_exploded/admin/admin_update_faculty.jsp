<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center" style="padding-top: 40px;">
    <form method="post" action="update" enctype="multipart/form-data">
        <fieldset style="width: 315px; padding-top: 30px; padding-bottom: 30px;">
            <legend>院系管理员信息修改</legend>
            <table width="600" border="0" cellpadding="0" cellspacing="0" align="center">
                <input type="hidden" name="id" value="${faculty.id}"/>
                <tr>
                    <td>
                        院系:
                    </td>
                    <td>
                        <select name="department">
                            <c:forEach items="${departments}" var="d">
                                <option value="${d.department}" <c:if test="${faculty.department == d.department}">selected</c:if>>${d.department}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        账号:
                    </td>
                    <td>
                        <input type="text" name="name" value="${faculty.name}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        密码:
                    </td>
                    <td>
                        <input type="text" name="pwd" value="${faculty.pwd}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <p id="des" style="color: red">
                            <c:if test="${updateResult == 'success'}">修改成功</c:if>
                            <c:if test="${updateResult == 'failed'}">修改失败</c:if>
                        </p>
                    </td>
                    <td><input type="submit" name="提交"/></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>
