//当页面一加载时就向后台发送post请求
$(function(){
    $.post("http://localhost:8080/user/getSession",function(obj){
        $("#userName").html(obj.userName+"欢迎你");
    },"json")
    console.log(1);
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