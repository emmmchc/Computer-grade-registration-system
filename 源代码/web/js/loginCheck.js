function trim(str)
{
    return str.replace(/(^\s*)|(\s*$)/g,'');
}

function check(){
    if(trim(form1.name.value)==""){
        alert("姓名不能为空！");
        form1.name.focus();
        return false;
    }
    if(form1.pwd.value==""){
        alert("密码不能为空！");
        form1.pwd.focus();
        return false;
    }
    return true;
}

function hid() {
    var err = document.getElementById("err");
    err.innerText = "";
}