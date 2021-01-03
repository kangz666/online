
function validate(){
    var agree=document.getElementById("agree");

    var number = document.getElementById("number");
    var password=document.getElementById("password")
    if(!agree.checked){
        alert("请先同意本站服务条款！");
        return false;
    }

    if(number.value == ""){
        alert("账号不能为空！")
        number.focus();
        return false;
    }
    if(password.value == ""){
        alert("密码不能为空！")
        password.focus();
        return false;
    }

    return true;
}

function showdiv(){
    document.getElementById("bg").style.display = "block";
    document.getElementById("show").style.display="block";

}
function hidediv(){
    document.getElementById("bg").style.display="none";
    document.getElementById("show").style.display="none";

}