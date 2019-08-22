<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台登录</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" />
<style>
	#deselect{
		font-size:20px;
		cursor:pointer;
	}
</style>
<script type="text/javascript">
	onload = function(){
		var qx = document.getElementById("deselect");
		var error = document.getElementById("error");
		qx.onclick = function(){
			error.style.display = "none";
		}
	}
</script>
</head>
<body>
	<img src="${pageContext.request.contextPath}/img/b1.jpg" id = "bg"/>
	<div id="adlog">
		<div id="div">
		<span>后台登录</span>
		<br><br>
		<div id="error">
			${error}<span id = "deselect">${qx}</span>
		</div>
		<form action="UserServlet?method=login" method="post">
			<input type="text" name = "nickname" class="input" placeholder="用户名"/> <br /><br/>
			<input type="password" name = "pwd" class="input" placeholder="密码"/> <br /><br />
			<button id = "btn">登录</button>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" id="clear" value="取消" />
		</form>
		</div>
	</div>
</body>
</html>