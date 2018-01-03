<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>中国东信渠道开放平台</title>
    <link rel="shortcut icon" href="img/weblogo.ico" type="image/x-icon" />
    <script type="text/javascript" src="js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <%--//登陆的js文件--%>
    <script type="text/javascript" src="js/system/login.js"></script>
    <%--//本页面css文件--%>
    <link rel="stylesheet" type="text/css" href="css/system/login.css" />

    <script type="text/javascript">
        if (window.self != window.top) {
            window.top.location = window.location;
        }
        function init() {
            $('#empName').focus();
            msgBox("");
            timeCount();
        }

    </script>
</head>
<body onload="init()">
<header>
    <div class="logo">
        <span class="main_logo"></span>
        <!--<sapn class="sub_logo"></sapn>-->
        <div class="sub_logo">
            <span>中国东信渠道开放平台</span>
        </div>
    </div>
    <!--<div class="return_home">-->
    <!--<a href="">返回首页</a>-->
    <!--</div>-->
</header>
<table class="loginbody">
    <tr>
        <td align="center" valign="middle">
            <table class="formbody">
                <tr>
                    <td align="center" valign="middle">
                        <div class="text">
                            <span>欢迎使用中国东信渠道开放平台</span>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <div class="text zhanghao">
                            <input id="empName" type="text" oninput="this.value=this.value.replace(/[\u4e00-\u9fa5]/g,'');" maxLength="15" placeholder="用户名" onkeydown=KeyDown() />
                        </div>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <div class="text password">
                            <input id="empPwd" style="ime-mode: disabled;" maxLength="15" type="password" placeholder="密码" onkeydown=KeyDown() />
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="text encode">
                            <%--不能输入汉字--%>
                            <input id="encode" maxLength="4" oninput="this.value=this.value.replace(/[\u4e00-\u9fa5]/g,'');" placeholder="验证码" style="display: inline-block;width: 56%;margin-left: 8px;" onkeydown=KeyDown() />
                           <a href="#" value="123" onclick="javascript:timeCount(countDown(this,5))"> <img id="img" src="#" alt="" style="display: inline-block;width: 33%;margin-bottom: -16px;" ></a>
                        </div>
                    </td>
                </tr>


                <tr align="center">
                    <td>
                        <div class="button">
                            <input class="login" type="button" value="登录" onclick="loginValidate(countDown(this,5));" />
                        </div>
                    </td>
                </tr>
                <tr>
                    <td align="center" valign="middle" class="error" height="20px">
                        <div id="msg" style="display: none;">
                            <img src="img/loading.gif" id='loading'>
                        </div>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
