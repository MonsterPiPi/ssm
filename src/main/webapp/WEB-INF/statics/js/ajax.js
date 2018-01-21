

function checkLoginEmail() {
    $.ajax({
        url:"/mavenSpringMVC/user/checkLoginEmail", //请求验证页面
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
    } else {
        $.ajax({
            type: "POST",
            url: "/mavenSpringMVC/user/login",
            data: {
                email: $("#email").val(),
                password: $("#password").val(),
            },
            dataType: "text",
            success: function (r) {

                var data = JSON.parse(r);
                console.log(data);
                if (data.msg=="成功"){
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
        url: "/mavenSpringMVC/user/register",
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
function  mySearchText(){
    var search= document.getElementById("searchText").value;
    //alert(search);
    console.log(search);
    $.ajax({
        type: "POST",
        url: "/mavenSpringMVC/blog/search",
        data: {
            searchText:search
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
mdui.JQ('#example-prompt-3').on('click', function () {
    mdui.prompt('请输入文本', '添加类别',
        function (value) {
            $.ajax({
                type: "POST",
                url: "/mavenSpringMVC/categories/add",
                data: {
                    name:value
                },
                dataType:"text",
                success:function (r) {
                    var data=JSON.parse(r);
                    console.log(data);
                    mdui.snackbar({
                        message: data.msg,
                        position: 'right-bottom'
                    });
                    toCategories();
                    //alert(data.code)
                },
                error: function (err) {
                    mdui.snackbar({
                        message: "Ajax出了点问题",
                        position: 'right-bottom'
                    });
                }
            });
        },
        function () {
            mdui.snackbar({
                message: "没有输入内容",
                position: 'right-bottom'
            });
        }
    );
});
function toLogin() {
    window.location.href = '/mavenSpringMVC/user/toLogin';//跳转到登陆界面
}
function toRegister() {
    window.location.href = '/mavenSpringMVC/user/toRegister';//跳转到注册界面
}
function toHome() {
    window.location.href = '/mavenSpringMVC/home/toHome';//
}
function toAbout() {
    $("#main").load("/mavenSpringMVC/home/toAbout");
}
function toCategories() {
    $("#main").load("/mavenSpringMVC/home/toCategories");
    $.ajax({
        type: "POST",
        url: "/mavenSpringMVC/categories/all",
        data: {
        },
        dataType:"text",
        success:function (r) {
            var html = "";
            var data=JSON.parse(r);
            console.log(data);
            for(var i=0;i<data.data.length;i++){    //遍历data数组
                var ls = data.data[i];
                html+=
                    "<li class=\"mdui-list-item mdui-ripple\">\n" +
                    "                        <div class=\"mdui-list-item-content\">\n" +
                    "                            <div class=\"mdui-list-item-title\">"+ls.name+"</div>\n" +
                    "                            <div class=\"mdui-list-item-text\">"+ls.createDate+"</div>\n" +
                    "                        </div>\n" +
                    "                        <label class=\"mdui-switch\">\n" +
                    "                            <input type=\"checkbox\" />\n" +
                    "                            <i class=\"mdui-switch-icon\"></i>\n" +
                    "                        </label>\n" +
                    "                    </li>";
            }
            $("#ulul").html(html); //在html页面id=ulul的标签里显示html内
            $("#categoriesNumber").html(data.data.length);
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
function toBlog() {
    $("#main").load("/mavenSpringMVC/home/toBlog");
}
function loginSuccess() {
    mdui.snackbar({
        message: "登陆成功",
        position: 'right-bottom'
    });
}
