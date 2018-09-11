<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>内容管理系统</title>
</head>
<body>
    <!--读取的数据传递到LoginServlet 在那里在进行后续操作-->
<form action="${pageContext.request.contextPath}/loginServlt" method="post">
   用户名:<input type="text"  placeholder="输入账号" name="adminname"><br/>
   密码：<input type="password"  placeholder="输入密码" name="adminpassword"><br/>
   <button type="submit">登陆</button>
</form>
</body>
</html>