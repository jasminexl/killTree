<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>出错了!!</title>
<style>
body{margin: 0;
position: relative;
}
.reloadbtn {
    position: fixed;
    top: 3%;
    right: 3%;
    width: 10px;
    height: 10px;
    border-style: none;
}
img {
    display: block;
    width: 200px;
    margin: 10px auto;
}
</style>
<script type="text/javascript">
function openmsg(){
	document.getElementById("msg").style.display="block";
}
function reloadbtn(){
  location.reload();
}
</script>
</head>

<body>
<button class="reloadbtn" onclick="javascript:reloadbtn();"></button>
<img src="${pageContext.request.contextPath}/img/what2.png" ondblclick="javascript:openmsg();"/>
<div id="msg" style="display:none;text-align: left;">${exceptionStack}</div>
</body>
</html>
