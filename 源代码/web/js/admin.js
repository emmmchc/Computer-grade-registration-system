function show(n) {
    var myiframe = document.getElementById("myiframe");
    if(n==1) {
        myiframe.src = "./PrintSign";
    }
    else if(n==2){
        myiframe.src = "./page2";
    }
    else if(n==3){
        myiframe.src = "./Faculties";
    }else if(n==4){
        myiframe.src = "./PrintStudent";
    }else if(n==5){
        myiframe.src = "admin/admin_change_pwd.jsp";
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
    var name = document.getElementById("name");
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
            console.log(xmlhttp.responseText);
        }
    }
    var url = "ChangePwd?name="+name.value+"&oldPwd="+oldPwd.value+"&newPwd="+newPwd.value+"&type="+"admin";
    xmlhttp.open("GET",url,true);
    xmlhttp.send();

}



function trim(str)
{
    return str.replace(/(^\s*)|(\s*$)/g,'');
}

function check2(){
    if(trim(name.value)==""){
        alert("账号不能为空！");
        name.focus();
        return false;
    }
    if(trim(pwd.value)==""){
        alert("密码不能为空！");
        pwd.focus();
        return false;
    }
    return true;
}

function hid() {
    var des = document.getElementById("des");
    des.innerText = "";
}








function hid() {
    var err = document.getElementById("des");
    err.innerText = "";
}