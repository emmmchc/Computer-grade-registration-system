<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>报名信息修改</title>
    <style type="text/css">
        input {
            width: 150px;
            height: 25px
        }
        tr {
            height: 30px;
        }
    </style>
</head>
<body>
<div align="center" style="padding-top: 40px;">
<form method="post" action="update" enctype="multipart/form-data">
    <input type="hidden" name="isUpload" id="isUpload" value="T" />
    <input type="hidden" name="id" value="${sign.id}" />
    <input type="hidden" name="signPicOld" value="${sign.signPic}" />
    <fieldset style="width: 315px; padding-top: 30px; padding-bottom: 30px;">
        <legend>考生信息修改</legend>
        <table width="600" border="0" cellpadding="0" cellspacing="0" align="center">
            <tr>
                <td>
                    学号:<input type="text" name="signNumber" value="${sign.signNumber}" readonly />
                </td>
                <td>
                    姓名:<input type="text" name="signName" value="${sign.signName}" />
                </td>
            </tr>
            <tr>
                <td>
                    性别:
                    <select name="signSex">
                        <option value="男" <c:if test="${sign.signSex=='男'}">selected</c:if>>男</option>
                        <option value="女" <c:if test="${sign.signSex=='女'}">selected</c:if>>女</option>
                    </select>
                </td>
                <td>
                    身份证号:<input type="text" name="signIdNumber" readonly value="${sign.signIdNumber}"/>
                </td>
            </tr>
            <tr>
                <td>
                    学院:
                    <select name="signDepartment">
                        <c:forEach items="${departments}" var="d">
                            <option value="${d.department}" <c:if test="${sign.signDepartment == d.department}">selected</c:if>>${d.department}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    考试地点:
                    <select name="signSite">
                        <option value="东校区" <c:if test="${sign.signSite=='东校区'}">selected</c:if>>东校区</option>
                        <option value="西校区" <c:if test="${sign.signSite=='西校区'}">selected</c:if>>西校区</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    考场号:<input type="text" name="signRoom" value="${sign.signRoom}" readonly />
                </td>
                <td>
                    座位号:<input type="text" name="signSeat" value="${sign.signSeat}" readonly/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="signLevel">报考级别: </label>
                    <select id="signLevel" name="signLevel">
                        <option value="${sign.signLevel}">${sign.signLevel}</option>
                    </select>
                </td>
                <td>
                    <label for="signSubject">报考科目: </label>
                    <select id="signSubject" name="signSubject">
                        <option value="${sign.signSubject}">${sign.signSubject}</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    准考证号:<input type="text" name="signExamNumber" size=8 value="${sign.signExamNumber}"/>
                </td>
                <td>
                    电话:<input type="tel" name="signPhone" size=8 value="${sign.signPhone}"/>
                </td>
            </tr>
            <tr>
                <td>
                    照片:<img width="120" height="90" src="${sign.signPic}">
                </td>
                <td>
                    新照片上传:<input type="file" name="signPic" id="pic" value="" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" name="submit" onclick="checkUpload()" value="修改"/>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</div>
</body>
</html>
<script>
    function checkUpload() {
        var kk = document.getElementById("pic");
        if(kk.value.length==0)
            document.getElementById("isUpload").value="F";
    }
</script>
<script type="text/javascript" src="js/二级联动.js" ></script>
