function checkLoginEmail() {
    $.ajax({
        url:"/mavenSpringMVC/checkLoginEmail", //请求验证页面
        type:"GET", //请求方式 可换为post 注意验证页面接收方式
        data:{email:$("#email").val()},//取得表文本框数据，作为提交数据 注意前面的 user 此处格式 key=value 其他方式请参考ajax手册
        dataType:"text",
        success: function(r)
        { //请求成功时执行操作
            var data=JSON.parse(r);
            if(data.code==0){
                mdui.snackbar({
                    message: "邮箱有效,可以登陆。",
                    position: 'right-bottom'
                });
            }else{
                mdui.snackbar({
                    message: "该邮箱未注册",
                    position: 'right-bottom'
                });
            }
        },
        error:function(){
            return false;
        }
    });
}
function userLogin(){
    if($("#email").val()==""){
        mdui.snackbar({
            message: "请输入邮箱",
            position: 'right-bottom'
        });
        event.preventDefault(); // 兼容标准浏览器
        window.event.returnValue = false; // 兼容IE6~8
        //alert(window.event.returnValue.ToString());
    }
    else if($("#password").val()==""){
        mdui.snackbar({
            message: "请输入密码",
            position: 'right-bottom'
        });
        event.preventDefault(); // 兼容标准浏览器
        window.event.returnValue = false; // 兼容IE6~8
    }else if($("#phone").val()==""){
        mdui.snackbar({
            message: "请输入手机号",
            position: 'right-bottom'
        });
        event.preventDefault(); // 兼容标准浏览器
        window.event.returnValue = false; // 兼容IE6~8
    }
    else {
        $.ajax({
            type: "POST",
            url: "/mavenSpringMVC/userLogin",
            data: {
                email: $("#email").val(),
                password: $("#password").val(),
            },
            dataType: "text",
            success: function (r) {
                var data = JSON.parse(r);
                console.log(data);
                if (data.msg=="成功"){
                    loginSuccess();
                    toHome();
                }else {
                    mdui.snackbar({
                        message: "登陆失败",
                        position: 'right-bottom'
                    });
                }


            },
            error: function (err) {
                mdui.snackbar({
                    message: "Ajax出了点问题",
                    position: 'right-bottom'
                });
            }
        });
    }
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
            //alert(data.code)
        },
        error: function (err) {
            mdui.snackbar({
                message: "Ajax出了点问题",
                position: 'right-bottom'
            });
        }
    });
}
function saveBlog() {

    $.ajax({
        type: "POST",
        url: "/mavenSpringMVC/saveBlog",
        data: {
            title:$("#title").val(),
            createTime:$("#nowDate").text(),
            categories:$("#categories").val(),
        },
        dataType:"text",
        success:function (r) {
            var data=JSON.parse(r);
            console.log(data);
            mdui.snackbar({
                message: data.msg,
                position: 'right-bottom'
            });
            //alert(data.code)
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
function toHome() {
    window.location.href = '/mavenSpringMVC/toHome';//跳转到注册界面
}
function toAbout() {
    $("#main").load("/mavenSpringMVC/toAbout");
}
function toCategories() {
    $("#main").load("/mavenSpringMVC/toCategories");
}
function toBlog() {
    $("#main").load("/mavenSpringMVC/toBlog");
}
function loginSuccess() {
    mdui.snackbar({
        message: "登陆成功",
        position: 'right-bottom'
    });
}