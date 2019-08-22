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
<title>编辑用户信息</title>
</head>
<style>
	#userEdit{
		font-family:黑体;
		font-size:30px;
	}
</style>
<body>
 <body>
   	<div id = "userEdit">编辑用户信息</div>
   	<hr />
   	<% 
   		String id = request.getParameter("id");
   		session.setAttribute("id", id);
   		List<User> users = (List<User>)session.getAttribute("userList");
   		for(User u:users){
   			if(u.getId() == Integer.valueOf(id)){
   				String nickname = u.getNickname();
   				String name = u.getName();
   				String password = u.getPassword();
   				String phone = u.getPhone();
   				
   				request.setAttribute("nickname", nickname);
   				request.setAttribute("name", name);
   				request.setAttribute("password", password);
   				request.setAttribute("phone", phone);
   			}
   		}
   	%>
   	<form action="UserServlet?method=update" method="post">
		用户名<input type = "text"  name = "nickname" value = "${requestScope.nickname }"/><br/> <br/>
		姓名<input type = "text"  name = "name" value = "${requestScope.name }"/><br/> <br/>
   		密码&nbsp&nbsp&nbsp&nbsp<input type = "password"  name = "pwd" value = "${requestScope.password }"/><br/><br/>
   		性别<input type = "radio"  name = "sex" value = "男" 
   		<c:if test="${user.sex == '男' }">
   			checked = "checked"
   		</c:if>
   		/>男 
   		   <input type = "radio"  name = "sex" value = "女" 
 		   <c:if test="${user.sex == '女' }">
 			  checked = "checked"
 		   </c:if>
   		   />女  <br/><br/>
   		手机号<input type = "text" name = "phone" value = "${requestScope.phone}" maxlength="11"/> <br/>
   		管理员 <input type = "radio"  name = "isadmin" value = "是" />是<input type = "radio"  name = "isadmin" value = "否" checked = ""/>否 <br/><br/>
   		<button>确认保存</button>
   	</form>
 	</body>
</body>
</html>