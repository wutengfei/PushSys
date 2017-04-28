<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>登录</h1>
	<form action="${pageContext.request.contextPath }/servlet/LoginServlet"
		method="GET">
		用户名：<input type="text" name="userName" /> 密 码：<input type="text"
			name="passWord" /> <input type="submit" value="登录" />
	</form>
	<%-- <h1>Get注册</h1>
	<form
		action="${pageContext.request.contextPath }/servlet/RegisterServlet"
		method="GET">
		用户名：<input type="text" name="userName" /> 密 码：<input type="text"
			name="passWord" /> <input type="submit" value="Get注册" />
	</form> --%>
	
	<form action="${pageContext.request.contextPath }/servlet/Push"
		method="get">
	 <input type="submit" value="推送" />
	</form>
</body>
</html>