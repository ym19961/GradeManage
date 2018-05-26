<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	function onSubmit(){
		var id = $("#id").val();
		var name = $("#name").val();
		var password1 = $("#password1").val();
		var password2 = $("#password2").val();
		if(id==""){
			alert("账号不能为空")
		}else if(name==""||password1==""||password2==""){
			alert("姓名或密码不能为空")
		}else{
			if(password1!=password2){
				alert("两次输入的密码不一致")
			}else{
				location.herf='../registerCheck.jsp';
			}
		}
	}
</script>
</body>
</html>