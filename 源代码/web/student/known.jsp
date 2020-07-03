<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
<head>
    <base href="<%=basePath%>">
    <title>考试须知</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<script>
		function choose(obj) {
			if(obj.checked == true){
				document.getElementById("agree").disabled = false;
				document.getElementById("agree").value = "同意";
			}
			else {
				document.getElementById("agree").disabled = true;
				document.getElementById("agree").value = "请勾选接受";
			}
		}
		function agree() {
			parent.window.document.getElementById("info").setAttribute("style","color:green;");
			parent.window.document.getElementById("infoConfig").setAttribute("disabled","false");
			window.location = "student/sign.jsp";
		}

	</script>
</head>
<body>
	<textarea id="txtareaNotice" style="width:100%;outline: none;resize:none;background-color:white;cursor:default;border:0;padding: 0 14px 14px 14px ;color: #536b82; font-size: 1em;line-height: 2.3em;" readonly rows="18">
	1．本报名网站的所有权归教育部考试中心，考生必须完全同意所有服务条款，方可进行网上报名。
	2．考生本人已阅读并同意遵守全国计算机等级考试的报名流程及考生须知。
	3．考生本人保证报名时提交的个人信息资料真实、正确，并将对个人信息不真实或不正确而导致无法参加考试以及其他直接或间接的后果负责。
	4．考生本人注册成功后，将使用自设定的密码和系统指定的用户名作为登录本网站的依据。考生本人将妥善保管自设定的密码和系统指定的用户名，并保证不向他人透露。否则，考生本人将对由此产生的所有后果负责。
	5．考生本人理解并同意，在报名过程中出现不可抗力所引起的无法正常报名的情况，本网站不承担任何直接或间接的责任。
	6．考生本人理解并同意，网上支付系统由支付平台所有并运营，在付费过程中由于支付平台系统问题导致的任何异常情况，本网站不承担直接或间接责任。
	7．考生本人理解并同意，在报名成功后，因本网站系统出现问题影响考生本人参加考试，本网站可能提供的补偿仅限于帮助安排重新报名或全额退还报名费，不承担任何其他连带责任。
	8．考生本人理解并同意，在同次考试中，考生只能报考同一科目一次，报考多次者将取消本次考试所有科目的成绩。
	9．考生本人理解并同意，在缴费完成后，考生不能修改个人信息及报考信息或退考。
	10．考生本人理解并同意，在报名成功后，由于考生个人原因而无法参加考试，由考生个人承担相关责任，教育部考试中心不进行退费。
	11．报名程序如有临时性变化，以本网站公告为准。
	12．本报名网站所收集的考生个人信息数据仅用于全国计算机等级考试报名，考生同意教育部考试中心按考务流程获知、处理、存储本人信息数据。
	13．考生本人已阅读并且理解全国计算机等级考试的有关规定和纪律要求，愿意在考试中自觉遵守这些规定，保证按规定的程序和要求参加考试，如有违反，自愿按《国家教育考试违规处理办法》有关条款接受处理。
	14．因本协议而引发的任何争议，由教育部考试中心住所地有管辖权的法院管辖。
	</textarea>
	<p align="center"><input type="checkbox" onclick="choose(this)"/><span style="color:red;padding: 0 10px 0 0;">*</span>我已阅读并接受遵守本网站报名协议</p>
	<p align="center">
		<input id="agree" type="button" disabled onclick="agree()" value="请勾选接受"/>
	</p>
</body>
</html>
