<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加商品</title>
<style>
#texta {
	width: 400px;
	height: 200px;
	resize: none;
}
</style>
</head>
<body>
	<h3>添加商品信息</h3>
	<hr>
	<form action="${pageContext.request.contextPath }/addgood">
		<span>商品名称</span> <input type="text" name = "goodName"/> <span>标题不能超过30个字符</span> <br>
		<span>所属大类</span> <select name="parentId">
			<option value="1">蛋糕类</option>
			<option value="2">饼干类</option>
			<option value="3">熟食类</option>
			<option value="4">素食类</option>
			<option value="5">坚果类</option>
			<option value="6">糖果类</option>
		</select> <br> <span>商品价格</span> <input type="text" name = "goodPrice"/> <br/>
		 <span>商品数量</span> <input type="text" name = "goodsStock"/><br> <span>商品描述</span>
		<br>
		<textarea id="texta" name = "goodDesc"></textarea>
		<br> <input type="submit" value="确认保存"
			style="background: #3E97C9" />
	</form>
</body>
</html>