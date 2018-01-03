<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>中国东信流量</title>
    <link rel="shortcut icon" href="../img/weblogo.ico" type="image/x-icon" />

    <!-- Bootstrap Core CSS -->
    <%--<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="../resources/bootstrap/css/bootstrap.css" rel="stylesheet">

    <link href="../resources/metisMenu/metisMenu.min.css" rel="stylesheet">


    <link href="../resources/dist/css/sb-admin-2.css" rel="stylesheet">


    <link href="../resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- DataTables Responsive CSS -->
    <!--<link href="../vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">-->

    <!-- Custom CSS -->
    <!--<link href="../dist/css/sb-admin-2.css" rel="stylesheet">-->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        function init(){
            //将渠道商的chcode放置到hiden的btn中，用于查询余额
            chcode = "${sessionScope.user.username}";
            $("#refreshBtn").val(chcode);
            selectMoney(chcode);
        }

        //       获取渠道商余额
        function selectMoney(chcode){
            setMoney("查询中...")
            $.ajax({
                url : "${pageContext.request.contextPath}/ChannelInfo/selectByChcode.do",
                data : {
                    "chcode" : chcode
                },
                type : "post",
                dataType : "json",
                cache : false,
                success : function(data) {
                    //未登录
                    // 需要优化：目前这样每一个方法都需要添加这个步骤，网上给出的提示是：修改JQuery源码 【notmodified】
                    if (data == 444) {
                        window.location = "../login.jsp";
                    } else if (data == 1){
                        setMoney("无");
                        alert("您没有管理的渠道~");
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
            $("#creditMoney").html(data.maxalarmmoney);
            $("#totalMoney").html(data.totalmoney);
            $("#updateDate").html(data.updatetime);
        }
        function exit() {
            if(confirm("确定要退出么？")){
                $.ajax({
                    url : "${pageContext.request.contextPath}/user/exit.do",
                    data : {},
                    type : "post",
                    dataType : "json",
                    cache : false,
                    success : function(data) {
                        if (data == 0){
                            window.location = "../login.jsp";
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
//      修改开始
        function openPopup() {
            $("#gray-bg").css("display","block");
            $("#pop-up").css("display","block");
        }
        function closePopup() {
            $("#gray-bg").css("display","none");
            $("#pop-up").css("display","none");
        }

    </script>
    <style>
        .gray-bg {
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: gray;
            opacity: .8;
            z-index: 100;
        }
        .pop-up {
            position: absolute;
            top: 50%;
            left: 50%;
            margin-top: -150px;
            margin-left: -150px;
            width: 300px;
            height: 300px;
            background-color: #fff;
            border: 1px solid #ccc;
            z-index: 101;
        }
        .pop-up-close {
            text-align: right;
            padding-right: 10px;
            padding-top: 5px;
        }
        .pop-up-close a {
            color: #000;
        }
        .pop-up-close a:hover {
            color: red;
        }
        .pop-up-group {
            height: 100px;
            line-height: 30px;
            padding-left: 10px;
        }





        .navbar {
            height: 80px;
            background-color: #313340;
            border-color: #313340;
        }
        .navbar-header a span {
            position: relative;
            top: -33px;
            left: 120px;
            color: wheat;
            font-size: 23px;
        }
        .navbar-right {
            margin-top: 15px;
        }
        .sidebar {
            margin-top: 80px;
        }
        ul#side-menu li > a {
            background-color: #454A5D;
            color: #eb8f00;
            font-size: 16px;
        }
        ul#side-menu ul a {
            background-color: #313340;
            color: #fff;
            font-size: 16px;
        }
        ul#side-menu ul a:hover {
            background-color: #F16C6D;
        }
    </style>
</head>

<body onload="init()">

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="../body.html">
                    <img title="logo" src="../img/main-logo.png"/>
                    <span>中国东信</span>
                </a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <%--修改开始--%>
                        <li><a href="#" onclick="javascript:openPopup()"><i class="fa fa-gear fa-fw"></i>修改密码</a>
                        </li>
                        <%--修改结束--%>
                        <li><a href="#" onclick="javascript:exit()"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->


            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="#" ><i class="fa fa-bar-chart-o fa-fw"></i> 渠道商余额<span class="fa arrow"></span></a>
                            <!-- /.nav-second-level -->
                        </li>

                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 id="channel" class="page-header">渠道商名称</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span id="money" style="font-size: 16px">当前余额</span>
                            <div class="pull-right btn-default">
                                <button id="refreshBtn" type="button" value="" onclick="javascript:selectMoney(this.value)" class="btn btn-default btn-xs ">
                                    刷新
                                    <i class="glyphicon glyphicon-refresh"></i>
                                </button>
                            </div>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables">
                                <thead>
                                    <tr>
                                        <th width="25%">渠道商名称</th>
                                        <th width="25%">授信额度</th>
                                        <th width="25%">余额</th>
                                        <th width="25%">更新时间</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="odd ">
                                        <td id="channelName">无</td>
                                        <td id="creditMoney">0.00</td>
                                        <td id="totalMoney">0.00</td>
                                        <td id="updateDate">无</td>
                                    </tr>
                                </tbody>
                            </table>

                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        </div>
        <!-- /#page-wrapper -->

        <%--弹窗开始--%>
        <div id="gray-bg" class="gray-bg" style="display: none">
        </div>
        <div id="pop-up" class="pop-up" style="display: none">
            <div class="pop-up-close">
                <a href="#" onclick="javascript:closePopup()"><i class="fa fa-close fa-fw"></i></a>
            </div>
            <div class="pop-up-group">
                <input type="text" placeholder="请输入原始密码"/>
            </div>
            <div class="pop-up-group">
                <input type="text" placeholder="请输入新密码"/>
            </div>
            <div class="pop-up-group">
                <input type="text" placeholder="请再次输入新密码"/>
            </div>
            <div class="pop-up-group">
                <button type="button">确认</button>
            </div>
        </div>

        <%--弹窗结束--%>

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../resources/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../resources/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../resources/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="../resources/datatables/js/jquery.dataTables.min.js"></script>
    <script src="../resources/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="../resources/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../resources/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>

</body>

</html>
