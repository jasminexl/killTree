<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>资源不存在</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
.STYLE1 {	font-family: "Microsoft YaHei";
	font-size: 27px;
	color: #FF0000;
	font-weight: bold;
}
.STYLE2 {	font-family: "Microsoft YaHei";
	font-size: 20px;
}
</style>
</head>

<body>
<table width="800" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"  style="border-collapse:collapse">
  <tr>
    <td width="442" colspan="5" align="center" valign="middle"><table width="798" border="0" align="center" cellpadding="0" cellspacing="2" bordercolor="#CCCCCC"  style="border-collapse:collapse">
      <tr>
        <td height="19" colspan="5" valign="middle"><p>&nbsp;</p>
          </td>
      </tr>
      <tr>
        <td width="100" height="265" rowspan="2" valign="middle">&nbsp;</td>
        <td width="413" height="116" valign="middle"><div align="left"><img src="img/gt.png" alt="" width="116" height="116" /></div></td>
        <td width="4" rowspan="2" valign="middle">&nbsp;</td>
        <td width="209" rowspan="2" valign="middle"><div align="center"><img src="img/sb.png" alt="" width="144" height="283" /></div></td>
        <td width="60" rowspan="2" valign="middle">&nbsp;</td>
      </tr>
      <tr>
        <td height="107" valign="top"><p align="left" class="STYLE1">对不起！</p>
          <p align="left" class="STYLE2">您访问的资源不存在或已被删除。</p></td>
      </tr>
      <tr>
        <td height="19" colspan="5" valign="middle">&nbsp;</td>
      </tr>
    </table>
    </td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>
