function userLogin(){
    $.ajax({
        type: "POST",
        url: "/mavenSpringMVC/userLogin",
        data: {
            email:$("#email").val(),
            password:$("#password").val(),
        },
        dataType:"text",
        success:function (r) {
            var data=JSON.parse(r);
            console.log(data)
            mdui.snackbar({
                message: data.msg,
                position: 'right-bottom'
            });
        },
        error: function (err) {
            mdui.snackbar({
                message: "Ajax出了点问题",
                position: 'right-bottom'
            });
        }
    });
}
function userRegister(){
    $.ajax({
        type: "POST",
        url: "/mavenSpringMVC/userRegister",
        data: {
            email:$("#email").val(),
            password:$("#password").val(),
            nickName:$("#nickName").val(),
            phone:$("#phone").val(),
            location:$("#location").val()
        },
        dataType:"text",
        success:function (r) {
            var data=JSON.parse(r);
            console.log(data)
            mdui.snackbar({
                message: data.msg,
                position: 'right-bottom'
            });
            alert(data.code)
        },
        error: function (err) {
            mdui.snackbar({
                message: "Ajax出了点问题",
                position: 'right-bottom'
            });
        }
    });
}
function toLogin() {
    window.location.href = '/mavenSpringMVC/toLogin';//跳转到登陆界面
}
function toRegister() {
    window.location.href = '/mavenSpringMVC/toRegister';//跳转到注册界面
}