//当页面一加载时就向后台发送post请求
$(function(){
    $.post("http://localhost:8080/user/getSession",function(obj){
        if(obj.userType != 'teacher') {
            if(getHtmlName() == 'system-teacher'){
                alert("无权访问");
                window.location.href = "../pages/system.html";
                return ;
            }
            document.querySelector("#teacher").style.visibility="hidden";
        }
        $("#userName").html(obj.userName+"欢迎你");
    },"json")
});

function logout() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/user/logout",
        success: function (data) {
            if (data.code == "200") {
                window.location.href = "../pages/login.html";
            } else {
                alert("登录失败" + data.message);
            }
        },
        error: function (data) {
            alert("登录失败，原因为" + data.message);
        }
    });
}

function getHtmlName() {
    var str = window.location.href;
    str = str.substring(str.lastIndexOf("/") + 1);
    str = str.substring(0, str.lastIndexOf("."));
    return str;
}