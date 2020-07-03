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
            <legend>注册学生信息修改</legend>
            <table width="600" border="0" cellpadding="0" cellspacing="0" align="center">
                <input type="hidden" name="id" value="${student.id}"/>
                <tr>
                    <td>
                        学号:
                    </td>
                    <td>
                        <input type="text" name="studentNumber" value="${student.studentNumber}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        姓名:
                    </td>
                    <td>
                        <input type="text" name="studentName" value="${student.studentName}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        性别:
                    </td>
                    <td>
                        <select name="studentSex">
                            <option value="男" <c:if test="${student.studentSex=='男'}">selected</c:if>>男</option>
                            <option value="女" <c:if test="${student.studentSex=='女'}">selected</c:if>>女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        学院:
                    </td>
                    <td>
                        <select name="studentDepartment">
                            <c:forEach items="${departments}" var="d">
                                <option value="${d.department}" <c:if test="${student.studentDepartment == d.department}">selected</c:if>>${d.department}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        电话:
                    </td>
                    <td>
                        <input type="tel" name="studentPhone" value="${student.studentPhone}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        密码:
                    </td>
                    <td>
                        <input type="password" name="studentPwd" value="${student.studentPwd}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        报名状态:
                    </td>
                    <td>
                        <select name="studentSign">
                            <option value="未报名" <c:if test="${student.studentSign=='未报名'}">selected</c:if>>未报名</option>
                            <option value="已报名" <c:if test="${student.studentSign=='已报名'}">selected</c:if>>已报名</option>
                        </select>
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
