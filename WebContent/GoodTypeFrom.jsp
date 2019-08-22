<%@page import="entity.GoodInfo"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="entity.GoodType"%>
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
	<% 
   		String id = request.getParameter("id");
   		session.setAttribute("id", id);
   		List<GoodType> goodTypes = (List<GoodType>)session.getAttribute("goodTypes");
   		for(GoodType g:goodTypes){
   			if(g.getId() == Integer.valueOf(id)){
   				String goodname = g.getGyte_name();
   				request.setAttribute("goodname", goodname);
   			}
   		}
   	%>
	<div>
		<h3>修改商品类别信息</h3>
	</div>
	<hr>	
	<span id="s">商品类别信息</span>
	<form action="${pageContext.request.contextPath }/updateGoodType" method="post">
		<input type="text" name="goodTypeName">
		<br>
		<br>
		<button>确认保存</button>
	</form>
	<span id="ss">标题不能超过30个字符</span>


</body>
</html>