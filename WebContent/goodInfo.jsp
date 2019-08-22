<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品信息页面</title>
<style>
	table{
		width:1000px
	}
	a{
		text-decoration: none;
	}
	#hiden{
		display:none;
	}
	form{
		display: inline-block;
	}
	button{
		cursor:pointer;
	}
</style>
<script type="text/javascript">
	onload = function(){
		var trs = document.getElementsByTagName("tr");
		for(var i = 0 ; i < trs.length ; i++){
			if(i % 2 == 0){
				trs[i].style.background = "#F0F5F7";		
			}else{
				trs[i].style.background = "#FFFFFF";	
			}
		}
		var insertBtn = document.getElementById("insert");
		var dele = document.getElementById("dele");
		insertBtn.onclick = function(){
			location.href = "<%= request.getContextPath()%>/insertShop.jsp";
		}
	}
	function del(id){
		if(confirm("确认删除？")){
			location.href = "deleteGood?id="+id;
		}
	}
	function edit(id){
		location.href = "Goodfrom.jsp?id="+id;
	}
</script>
</head>
<body>
	<div>
		<button id = "insert">添加</button> <button>修改</button> <button>删除</button>
	</div>
	<div>
		<table border = "1px" cellspacing="0px" cellpadding="0px">
			<tr>
				<td><input type = "checkbox" name = "selectAll"></td>
				<td>商品编号</td>
				<td>商品名称</td>
				<td>商品描述</td>
				<td>数量</td>
				<td>单价</td>
				<td>操作</td>
			</tr>
		<c:forEach items="${goods}" var = "good">
			<tr>
				<td><input type = "checkbox" name = "select"></td>
				<td>${good.id}</td>
				<td>${good.goods_name}</td>
				<td>${good.goods_description}</td>
				<td>${good.goods_stock}</td>
				<td>${good.goods_price}</td>
				<td>
					<a href = "javascript:edit(${good.id})">编辑</a>
					<a href = "javascript:del(${good.id})">删除</a>
				</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>