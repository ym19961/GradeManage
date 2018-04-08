<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
 %>
 <link rel="stylesheet" href="<%=path%>/css/style.css" type="text/css"
	media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢迎来到学生成绩管理系统</title>
</head>
<body onkeydown="keyLogin();">
<div class="h1"><h1>欢迎来到学生成绩管理系统</h1></div>
<div class="box">
<div class="left">
<img src="<%=request.getContextPath()%>/images/001.jpg">
</div>
<div class="right">
	<form name="form1" action="Login" method="POST">
		<select class="choose" name="type"  id="type">
				<option>请选择登录用户类型</option>
				<option id="student" value="student" >学生</option>							
				<option id="teacher" value="teacher" >教师</option>								
		</select>
		<br><br><li>账号</li><br>				
			<input type="text" id="id" name="id" class="id" placeholder="请输入账号">
		<li>密码</li><br>
		<input type="password" id="password" name="password" class="password" placeholder="请输入密码">
		<input  type="submit" id="sub" value="登录"  />
	</form>
<form class="form" name="form" action="registerTeacher.jsp" method="POST">
<input  type="submit" id="sub" value="教师注册"  />
</form>
<form class="form" name="form" action="register.jsp" method="POST">
<input  type="submit" id="sub" value="学生注册"  />
</form>
</div>
</div>
</body>
<script type="text/javascript">
	function keyLogin(){  
		  if (event.keyCode==13)   //回车键的键值为13  
		     document.getElementById("sub").click();  //调用登录按钮的登录事件  
		} 
</script>
</html>