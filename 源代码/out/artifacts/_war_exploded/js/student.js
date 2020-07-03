function show(n) {
    var myiframe = document.getElementById("myiframe");
    if(n==1) {
        var a = document.getElementById("info");
        if(a.getAttribute("disabled")=="false")
            myiframe.src = "student/known.jsp";
    }
    else if(n==2){
        var a = document.getElementById("infoConfig");
        if(a.getAttribute("disabled")=="false")
            myiframe.src = "student/sign.jsp";
    }
    else if(n==3){
        var a = document.getElementById("mySign");
        if(a.getAttribute("disabled")=="false")
            myiframe.src = "./PrintSign";
    }
    else if(n==4){
        var a = document.getElementById("changePwd");
        if(a.getAttribute("disabled")=="false")
            myiframe.src = "student/change_pwd.jsp";
    }
}

function check() {
    var oldPwd = document.getElementById("oldPwd");
    var newPwd = document.getElementById("newPwd");
    var newPwd2 = document.getElementById("newPwd2");
    if(oldPwd.value==""){
        alert("密码不能为空！");
        oldPwd.focus();
        return ;
    }
    if(newPwd.value==""){
        alert("新密码不能为空！");
        newPwd.focus();
        return ;
    }
    if(newPwd2.value==""){
        alert("新密码(二次确认)不能为空！");
        newPwd2.focus();
        return ;
    }
    if(newPwd.value!=newPwd2.value) {
        alert("确认密码与新密码不一致！");
        newPwd2.focus();
        return;
    }
    var stuid = document.getElementById("stuid");
    var oldPwd = document.getElementById("oldPwd");
    var newPwd = document.getElementById("newPwd");
    var xmlhttp;
    if (window.XMLHttpRequest)
    {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("des").innerText = xmlhttp.responseText;
        }
    }
    var url = "ChangePwd?name="+stuid.value+"&oldPwd="+oldPwd.value+"&newPwd="+newPwd.value+"&type="+"student";
    xmlhttp.open("GET",url,true);
    xmlhttp.send();
}

function hid() {
    var err = document.getElementById("des");
    err.innerText = "";
}