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

    <title>中国东信渠道开放平台</title>
    <link rel="shortcut icon" href="../../img/weblogo.ico" type="image/x-icon" />

    <script type="text/javascript" src="../../js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="../../js/common.js"></script>


    <!-- Bootstrap Core CSS -->
    <%--<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="../../resources/bootstrap/css/bootstrap.css" rel="stylesheet">

    <link href="../../resources/metisMenu/metisMenu.min.css" rel="stylesheet">


    <link href="../../resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <link href="../../resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <%--//查询余额的js文件--%>
    <script type="text/javascript" src="../../js/system/findMoney.js"></script>
    <%--//本页面css文件--%>
    <link rel="stylesheet" type="text/css" href="../../css/system/findMoney.css" />


    <script type="text/javascript">

        var basePath = "${pageContext.request.contextPath}";
        function init(){
            closePopup();
            //将渠道商的chcode放置到hiden的btn中，用于查询余额
            $("#money").val("${sessionScope.user.username}")
            selectMoney();
        }

        //开启模态框
        function openPopup() {
            $("#gray-bg").css("display","block");
            $("#pop-up").css("display","block");
        }
        //关闭模态框
        function closePopup() {
            $("#gray-bg").css("display","none");
            $("#pop-up").css("display","none");
        }


    </script>
    <style>

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
                    <img title="logo" src="../../img/main-logo.png"/>
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
                        <li><a href="#" onclick="javascript:openPopup()"><i class="fa fa-gear fa-fw"></i>修改密码</a>
                        </li>
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
                            <span id="money" value="" style="font-size: 16px">当前余额</span>
                            <div class="pull-right btn-default" style="border-radius: 10px">
                                <input id="refreshBtn" style="width: 60px; height: 26px" class="btn btn-default btn-xs" type="button" value=" 刷新 " onclick="selectMoney(countDown(this,5));" />
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
        <div id="gray-bg" class="gray-bg" >
        </div>
        <div id="pop-up" class="pop-up">
            <div class="pop-up-close">
                <a href="#" onclick="javascript:closePopup()"><i class="fa fa-close fa-fw"></i></a>
            </div>
            <div class="pop-up-content">
                <div class="pop-up-group">
                    <input id="oldPWD" maxLength="15" type="password" placeholder="请输入原始密码"/>
                </div>
                <div class="pop-up-group">
                    <input id="newPWD" maxLength="15" type="password" placeholder="请输入新密码"/>
                </div>
                <div class="pop-up-group">
                    <input id="renewPWD" maxLength="15" type="password" placeholder="请再次输入新密码"/>
                </div>
                <div class="pop-up-group">
                    <button onclick="changePWD('${sessionScope.user.password}')" type="button">确认</button>
                </div>
            </div>
        </div>

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../../resources/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../../resources/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../../resources/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="../../resources/datatables/js/jquery.dataTables.min.js"></script>
    <script src="../../resources/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="../../resources/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../../resources/dist/js/sb-admin-2.js"></script>

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
