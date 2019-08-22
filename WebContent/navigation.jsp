<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>导航页</title>
<link rel = "stylesheet" href = "${pageContext.request.contextPath}/css/navigation.css" />
</head>
<body>
	<div id = "welcome"><marquee loop=3 behavior=alternate>欢迎登录${user.nickname}</marquee></div>
	<div id = "a">
	<h2>管理信息</h2>
	</div>
	<div class = "b">
		<ul>
			<li><a href = "${pageContext.request.contextPath}/selectGoodType">商品类别管理</a> <br></li>
			<li><a href = "UserServlet?method=selectAllUsers">用户管理</a> <br></li>
			<li><a href = "${pageContext.request.contextPath}/selectGood">商品管理</a> <br></li>
			<li><a>订单管理</a> <br></li>
		</ul>
	</div>
</body>
</html>