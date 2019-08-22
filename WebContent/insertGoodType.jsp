<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#s{
   position: absolute;
   top:127px;
   left:50px;
}
form{
   position: absolute;
   top:120px;
   left:160px;

}
input{
    width:240px;
    height:30px;

}
#ss{
   position: absolute;
   top:128px;
   left:425px;
   font-size: 14px;
   color: gray;

}
</style>
</head>
<body>
	<div>
		<h3>添加商品类别信息</h3>
	</div>
	<hr>	
	<span id="s">商品类别名称</span>
	<form action="${pageContext.request.contextPath }/insertType" method="post">
		<input  type="text" name="goodTypeName">
		<br>
		<br>
		<button>确认保存</button>
	</form>
	<span id="ss">标题不能超过30个字符</span>


</body>
</html>