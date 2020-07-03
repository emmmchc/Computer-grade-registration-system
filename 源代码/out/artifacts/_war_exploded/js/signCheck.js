function trim(str)
{
    return str.replace(/(^\s*)|(\s*$)/g,'');
}

function check(){
    if(trim(signIdNumber.value)==""){
        alert("身份证号不能为空！");
        signIdNumber.focus();
        return false;
    }
    if(trim(signPhone.value)==""){
        alert("电话不能为空！");
        signPhone.focus();
        return false;
    }
    var signLevel = document.getElementById("signLevel");
    console.log(signLevel.options[0].text);
    return true;
}

function hid() {
    var des = document.getElementById("des");
    des.innerText = "";
}