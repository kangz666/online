function validate(){

    var number = document.getElementById("number");
    var agree=document.getElementById("agree");
    var password=document.getElementById("password")

    if(number.value == ""){
        alert("账号不能为空！")
        number.focus();
        return false;
    }
    if(password.value == ""){
        alert("密码不能为空！")
        password.focus();
        return false;
    }else if(password.lenth>6||password.length<12){
        alert("密码长度不符合要求<应在6-12>之间");
        password.focus();
        return false;
    }
    if(!agree.checked){
        alert("请先同意本站服务条款！");
        return false;
    }
    return true;
}
