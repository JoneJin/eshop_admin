<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息页面</title>
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
<script type="text/javascript" src = "js/jquery1.11.3.min.js"></script>
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
		
		var deleBatchBtn = document.getElementById("deleBatch");
		
		insertBtn.onclick = function(){
			location.href = "<%= request.getContextPath()%>/addUserFrom.jsp";
		}
		
		deleBatchBtn.onclick = function(){
			var ids = "";
			var tags = document.getElementsByName("claimCase");
			for(var i=0;i<tags.length;i++){
				if(tags[i].checked){
					ids += tags[i].value+"-";
				}
			}
			if(confirm("确定要删除吗?")){
				location.href = "UserServlet?method=deleteOneUser&ids="+ids;
			}
		}
	}
	
	function del(id){
		if(confirm("确定要删除吗?")){
			location.href = "UserServlet?method=deleteOneUser&id="+id;
		}
	}
	
	function edit(id){
		location.href = "userFrom.jsp?id="+id;
	}
	
	//批量勾选的功能
	function selectAll(){
		obj = document.getElementsByName("claimCase");
		selected = document.getElementsByName("parentClaim");
		for(k in obj){
			obj[k].checked = selected[0].checked;
		}
	}
	//单次勾选功能
	function select(){
		obj = document.getElementsByName("claimCase");
		for(k in obj){
			obj[k].checked = "checked";
			alter(obj[k].checked)
		}
	}
</script>

</head>
<body>
	<div>
		<button id = "insert">添加</button> <button>修改</button> <button id = "deleBatch">批量删除</button>
	</div>
	<div>
		<table border = "1px" cellspacing="0px" cellpadding="0px">
			<tr>
				<td><input type = "checkbox" name = "parentClaim" onclick = "selectAll()"></td>
				<td>用户编号</td>
				<td>用户名</td>
				<td>姓名</td>
				<td>密码</td>
				<td>性别</td>
				<td>手机号</td>
				<td>是否是管理员</td>
				<td>操作</td>
			</tr>
		<c:forEach items="${userList }" var = "user">
			<tr>
				<td><input type = "checkbox" name = "claimCase" value = "${user.id}" onclick = "select()"></td>
				<td>${user.id}</td>
				<td>${user.nickname}</td>
				<td>${user.name}</td>
				<td>${user.password}</td>
				<td>${user.sex}</td>
				<td>${user.phone}</td>
				<td>${user.is_admin}</td>
				<td>
					<a href = "javascript:edit(${user.id})">编辑</a>
					<a href = "javascript:del(${user.id})">删除</a>
				</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>