var localObj = window.location;

var contextPath = localObj.pathname.split("/")[1];

var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;

//获取渠道商余额
function selectMoney(){
    setMoney("查询中...")
    $.ajax({
        url : basePath+"/ChannelInfo/selectByChcode.do",
        data : {
            "chcode" : $("#money").val()
        },
        type : "post",
        dataType : "json",
        cache : false,
        success : function(data) {
            //未登录
            // 需要优化：目前这样每一个方法都需要添加这个步骤，网上给出的提示是：修改JQuery源码 【notmodified】
            if (data == 444) {
                window.location = "../../login.jsp";
            } else if (data == 1){
                setMoney("无");
                alert("您的管理的渠道，本月无交易");
            }else {
                show(data);
            }
        }
    });
}
//展示余额信息
function show(data) {
    $("#channel").html(data.nameqc);
    $("#money").html("当前余额");
    $("#channelName").html(data.chname);
    $("#creditMoney").html(Math.abs(data.maxalarmmoney));
    $("#totalMoney").html(data.runmoney);
    $("#updateDate").html(data.inserttime);
}
function exit() {
    if(confirm("确定要退出么？")){
        $.ajax({
            url : basePath+"/user/exit.do",
            data : {},
            type : "post",
            dataType : "json",
            cache : false,
            success : function(data) {
                if (data == 0){
                    window.location = basePath+"/login.jsp";
                }
            }
        });
    }
}
//清除输入的密码信息
function cleanPWD(){
    $("#oldPWD").val("");
    $("#newPWD").val("");
    $("#renewPWD").val("");
}

//修改密码
function changePWD(oldPWD){
    //验证密码
    if(!checkPWD(oldPWD)){
        cleanPWD();
        return
    }
    if(confirm("确定修改密码？")){
        $.ajax({
            url : basePath+"/user/changePWD.do",
            data : {
                "userno" : $("#money").val(),
                "pwd" : check($("#newPWD").val()),
                "newPWD" : $("#newPWD").val()

            },
            type : "post",
            dataType : "json",
            cache : false,
            success : function(data) {
                if (data == 1){
                    alert("系统错误，请联系管理员~")
                    cleanPWD();
                }else if (data == 0){
                    alert("修改成功！")
                    cleanPWD();
                    closePopup();
                }
            }
        });
    }
}

function setMoney(str) {
    $("#money").html(str);
    $("#channelName").html(str);
    $("#creditMoney").html(str);
    $("#totalMoney").html(str);
    $("#updateDate").html(str);
}

//验证密码合法性 正确性
function checkPWD(oldPWD) {
    if(checkInput($("#oldPWD").val()) || checkInput($("#newPWD").val()) || checkInput($("#renewPWD").val())){
        return false;
    }
    if(check($("#oldPWD").val()) != oldPWD){
        alert("您输入的原始密码错误！")
        return false;
    }
    if($("#oldPWD").val() == $("#newPWD").val()){
        alert("您要修改的密码和原始密码相同！")
        return false;
    }
    if($("#newPWD").val() != $("#renewPWD").val()){
        alert("您两次输入的密码不相同！")
        return false;
    }
    return true;
}


function checkInput(str) {
    //判断字符串是否符合要求,长度为4~15位
    if (str == "" || str == null || str.length < 4){
        alert("您的密码长度应为4~15位！!");
        cleanPWD();
        return true;
    }
    //检查特殊字符
    var containSpecial = RegExp(/[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);
    var special = containSpecial.test(str);
    if(special){
        alert("您输入的密码中含有特殊字符!");
        cleanPWD();
        return special;
    }
    return false;
}