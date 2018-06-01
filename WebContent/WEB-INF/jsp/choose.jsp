<%@ page language="java" import="com.demo.Manager" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.*"%>
<!DOCTYPE html>
<html>
<head>
 <%
 	String id=request.getParameter("id");
    Manager m = new Manager(); 
 	out.println("您好，"+m.getTeacherName(id)+"\n");
 	session.setAttribute("TeacherId", id);
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
 %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=path%>/css/style.css" type="text/css"
	media="all" />
    <script src="<%=path%>/js/jquery-2.2.2.min.js"></script>
	<script src="<%=path%>/js/jquery-3.2.1.min.js"></script>
<script src="<%=path%>/js/jquery.mobile-1.4.5.min.js"></script>
<title>登录</title>
</head>
<body onkeydown="keyLogin();">
	<div class="form1">
	<form name="form1" action="Choose" method="POST">
		<p>请选择功能</p>
		<select class="choose" name="type" id="type">
				<option>请选择功能</option>
				<option id="record" value="record" >录入成绩</option>
				<option id="query" value="query" >查询</option>								
		</select>
			<input  type="submit" id="sub" value="确定"  />
	</form>
	</div>
</body> 
<script type="text/javascript">
	function keyLogin(){  
		  if (event.keyCode==13)   //回车键的键值为13  
		     document.getElementById("sub").click();  //调用登录按钮的登录事件  
		} 
</script>
</html>