<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "com.demo.Manager ,java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
 <%
	Manager manager=new Manager();
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
<title>学生注册</title>
</head>
<body onkeydown="keyLogin();">
	<div class="form1">
	<form name="form1" action="Register" method="POST">
		<p >账号</p>				
		<input type="text" id="id" name="id" class="id" placeholder="请输入账号">
		<p>姓名</p>
		<input type="text" id="name" name="name" class="name" placeholder="请输入姓名">
		<p>密码</p>
		<input type="password" id="password1" name="password1" class="password" placeholder="请输入密码">
		<p>确认密码</p>
		<input type="password" id="password2" name="password2" class="password" placeholder="再次输入密码">
		<p>班级</p>
		<select name="StudentClass">
			<option>请选择班级</option>
			<option value="Class1">计算机1501班</option>
			<option value="Class2">计算机1502班</option>
			<option value="Class3">计算机1503班</option>
		</select>
		<input  type="submit" id="sub" value="提交"  />
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