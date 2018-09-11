<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>添加用户</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
</head>

<body>


	<div class="tpl-content-page-title">添加用户</div>
	<div>
        <!--修改后的数据通过UserAddServlet 到 UserListServlet 最后传递到 index.jsp -->
		<form action="${pageContext.request.contextPath }/UserAddServlet"
			method="post">
			<div>
				<label>用户名 / UserName</label>
				<div>
					<input type="text" id="usern-name" placeholder="用户名 / UserName"
						name="username"> <small>输入你的账号，让我们记住你。</small>
				</div>
			</div>

			<div>
				<label>密码 / Password</label>
				<div>
					<input type="password" id="pwd" placeholder="密码 / Password"
						name="password"> <small>输入你的密码，方便登录。</small>
				</div>
			</div>

			<div>
				<div>
					<button type="submit" class="am-btn am-btn-primary">保存修改</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>