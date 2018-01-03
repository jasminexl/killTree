var localObj = window.location;

var contextPath = localObj.pathname.split("/")[1];

var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;

var time;
//验证码
function changeImg() {
    date = new Date().getTime();
    $("#img").val(date);
    var img = document.getElementById("img");
    img.src = basePath+"/vail/autoImg.do?date=" + date;
}

//每两分钟重新执行该函数
function timeCount() {
    clearTimeout(time);
    changeImg();
    time = setTimeout("timeCount()",120000)
}

//按下Enter进行登陆
function KeyDown()
{
    if (event.keyCode == 13)
    {
        event.returnValue=false;
        event.cancel = true;
        loginValidate();
    }
}

function loginValidate() {
    if (!checkInput()){
        return
    }
    msgBox("<img src='img/loading.gif'>");
    $.ajax({
        url : basePath+"/user/login.do?",
        data : {
            "userno" : check($.trim($("#empName").val())),
            "pwd" : check($.trim($("#empPwd").val())),
            "date" : $("#img").val(),
            "encode" : check(encode64($.trim($("#encode").val())))
        },
        type : "post",
        dataType : "json",
        cache : false,
        success : function(data) {
            msgBox("");
            if (data == 0) {
                clearTimeout(time)
                $("#encode").val("")
                window.location.href = basePath+"/views/system/findmoney.jsp";
                console.log(check($.trim($("#empName").val())));
            } else if (data == 1) {
                msgBox("验证码错误！");
            } else if (data == 3) {
                msgBox("用户名或密码错误！");
            } else if (data == 2) {
                msgBox("该用户被冻结！");
            }else if (data == 4) {
                msgBox("系统错误！请联系负责人~");
            } else {
                msgBox("未知错误！请联系负责人~");
            }
            changeImg();
        }
    });
}
function msgBox(str) {
    if (str.length > 0) {
        $(".error #msg").html(str);
        $(".error #msg").show();
    } else {
        $(".error #msg").hide();
    }
}

function checkInput() {
    //检查输入信息字符长度
    if (checkStr($.trim($("#empName").val())) || checkStr($.trim($("#empPwd").val())) || checkStr($.trim($("#encode").val()))) {
        changeImg();
        return false;
    }
    if ($.trim($("#encode").val()).length != 4){
        changeImg();
        msgBox("验证码长度为4位！");
        $("#encode").val("")
        return false;
    }
    return true;
}
function checkStr(str) {
    //判断字符串是否符合要求,长度为4~15位
    if (str == "" || str == null){
        msgBox("您的登陆信息不可为空");
        return true;
    }
    //检查特殊字符
    var containSpecial = RegExp(/[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);
    if(containSpecial.test(str)){
        msgBox("您输入的登陆信息中含有特殊字符!");
        return containSpecial.test(str);
    }
    return false;
}
