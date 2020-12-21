//绑定otp
function login() {
    var loginNumber = $("#login_number").val();
    var password = $("#login_password").val();
    if (loginNumber == null || loginNumber == "") {
        alert("学号不能为空");
        return false;
    }
    if (password == null || password == "") {
        alert("密码不能为空");
        return false;
    }
    var da = {
        "loginNumber": loginNumber,
        "password": password
    };
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/user/login",
        contentType: "application/json",
        data: JSON.stringify(da),
        dataType: "json",
        success: function (data) {
            if (data.code == "200") {
                window.location.href = "../pages/system.html";
            } else {
                alert("登录失败" + data.message);
            }
        },
        error: function (data) {
            alert("登录失败，原因为" + data.message);
        }
    });
    return false;
}

function test() {
    alert("请找老师重置密码");
}

//监听Enter键自动提交事件
$(document).keyup(function(event){
    if (event.key == 13) {
        login();
    } else if (event.keyIdentifier == 13) {
        login();
    } else if (event.keyCode == 13) {
        login();
    }
});