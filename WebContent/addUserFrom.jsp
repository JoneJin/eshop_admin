<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户</title>
</head>
<style>
	#userEdit{
		font-family:黑体;
		font-size:30px;
	}
</style>
<body>
 <body>
   	<div id = "userEdit">添加用户信息</div>
   	<hr/>
   	<form action="UserServlet?method=add" method="post">
		用户名<input type = "text"  name = "nickname"/><br/> <br/>
		姓名<input type = "text"  name = "name"/><br/><br/>
   		密码&nbsp&nbsp&nbsp&nbsp<input type = "password"  name = "pwd"/><br/><br/>
   		性别<input type = "radio"  name = "sex" value = "男"/>男 <input type = "radio"  name = "sex" value = "女"/>女   <br/><br/>
   		手机号<input type = "text" name = "phone"/>
   		管理员 <input type = "radio"  name = "isadmin" value = "是"/>是<input type = "radio"  name = "isadmin" value = "否"/>否 <br/><br/>
   		<button>添加</button>
   	</form>
 	</body>
</body>
</html>