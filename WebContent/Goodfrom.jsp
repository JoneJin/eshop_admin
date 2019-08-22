<%@page import="entity.GoodInfo"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改商品信息</title>
</head>
<style>
	#userEdit{
		font-family:黑体;
		font-size:30px;
	}
	#texta {
		width: 400px;
		height: 200px;
		resize: none;
	}
</style>
<body>
 <body>
   	<div id = "userEdit">修改商品信息</div>
   	<hr />
   	<% 
   		String id = request.getParameter("id");
   		session.setAttribute("id", id);
   		List<GoodInfo> goods = (List<GoodInfo>)session.getAttribute("goods");
   		for(GoodInfo g:goods){
   			if(g.getId() == Integer.valueOf(id)){
   				String goodname = g.getGoods_name();
   				String gooddesc = g.getGoods_description();
   				double goodprice = g.getGoods_price();
   				int goodstock = g.getGoods_stock();
   				int parentid = g.getGoods_parentid();
   				
   				request.setAttribute("goodname", goodname);
   				request.setAttribute("gooddesc", gooddesc);
   				request.setAttribute("goodprice", goodprice);
   				request.setAttribute("goodstock", goodstock);
   				request.setAttribute("parentid", parentid);
   			}
   		}
   	%>
	<form action="${pageContext.request.contextPath }/updateGood">
		<span>商品名称</span> <input type="text" name = "goodName" value = "${requestScope.goodname }"/> <span>标题不能超过30个字符</span> <br>
		<span>所属大类</span> <select name="parentId">
			<option value="1">蛋糕类</option>
			<option value="2">饼干类</option>
			<option value="3">熟食类</option>
			<option value="4">素食类</option>
			<option value="5">坚果类</option>
			<option value="6">糖果类</option>
		</select> <br> <span>商品价格</span> <input type="text" name = "goodPrice" value = "${requestScope.goodprice }"/> <br/>
		 <span>商品数量</span> <input type="text" name = "goodsStock" value = "${requestScope.goodstock }" />
		 <span>商品折扣</span> <input type="text" name = "goodsdiscount" value = "0.8" />
		 <br> <span>商品描述</span>
		<br>
		<textarea id="texta" name = "goodDesc">${requestScope.gooddesc }</textarea>
		<br> <input type="submit" value="确认保存"
			style="background: #3E97C9" />
	</form>
 	</body>
</body>
</html>