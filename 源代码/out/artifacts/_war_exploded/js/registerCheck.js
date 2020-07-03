function trim(str)
{
    return str.replace(/(^\s*)|(\s*$)/g,'');
}

function check2(){
    if(trim(studentNumber.value)==""){
        alert("学号不能为空！");
        studentNumber.focus();
        return false;
    }
    if(trim(studentName.value)==""){
        alert("姓名不能为空！");
        studentName.focus();
        return false;
    }
    if(trim(studentAge.value)==""){
        alert("年龄不能为空！");
        studentAge.focus();
        return false;
    }
    if(trim(studentPhone.value)==""){
        alert("电话不能为空！");
        studentPhone.focus();
        return false;
    }
    if(trim(studentPwd.value)==""){
        alert("密码不能为空！");
        studentPwd.focus();
        return false;
    }
    return true;
}

function hid() {
    var des = document.getElementById("des");
    des.innerText = "";
}