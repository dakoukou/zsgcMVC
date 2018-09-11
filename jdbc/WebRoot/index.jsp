<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>登陆验证</title>
</head>
<body>
 欢迎管理员 ${sessionScope.Adminname}
	<div>用户列表</div>
	<div>
		<button type="button" id="add">添加用户</button>
		<button type="button" id="update">修改</button>
		<button type="button" id="delete">删除</button>



		<div>
			<table>
				<thead>
					<tr>
						<th><input type="checkbox"></th>
						<th>用户id</th>
						<th>用户名</th>
						<th>密码</th>
					</tr>
				</thead>
				<tbody>
                   <c:forEach items="${sessionScope.userlist }" var="user">
                   
                   
					<tr>
						<td><input type="checkbox" value="${user.userid}" class="cbx"></td>
						<td>${user.userid}</td>
						<td>${user.username}</td>
						<td>${user.password}</td>

					</tr>
				</c:forEach>
				</tbody>
			</table>
			<hr>
		</div>

	</div>

	<script type="text/javascript">
		//创建添加链接，进入添加界面
		document.getElementById("add").onclick = function add() {
            //添加界面的路径
			window.location.href = "${pageContext.request.contextPath}/admin/user/user_add.jsp";
		};
		//创建修改连接
		document.getElementById("update").onclick = function update() {
			var cbx = document.getElementsByClassName("cbx");
			var userid = 0;
			var num = 0;
			//用来统计选中了几个
			for (var i = 0; i < cbx.length; i++) {
				if (cbx[i].checked) {
					num++;
				}
			}
			if (num > 1) {
				alert("只能选择一条数据！");
			} else if (num == 1) {
				//选中的值
				for (var i = 0; i < cbx.length; i++) {
					if (cbx[i].checked) {
						userid = cbx[i].value;
					}
				}
                //利用userid进行修改操作
				window.location.href = "${pageContext.request.contextPath}/UserToUpdateServlet?userid="
						+ userid;
			} else {
				alert("必须选择一条数据！");
			}
		};
		//执行删除操作
		document.getElementById("delete").onclick = function deletes() {
			var cbx = document.getElementsByClassName("cbx");
			var userid = 0;
			var num = 0;
			//用来统计选中了几个
			for (var i = 0; i < cbx.length; i++) {
				if (cbx[i].checked) {
					num++;
				}
			}
			if (num > 1) {
				alert("只能选择一条数据！");
			} else if (num == 1) {
				//选中的值
				for (var i = 0; i < cbx.length; i++) {
					if (cbx[i].checked) {
						userid = cbx[i].value;
					}
				}
                //利用userid进行删除操作 利用UserDeleteServlet
				window.location.href = "${pageContext.request.contextPath}/UserDeleteServlet?userid="
						+ userid;
			} else {
				alert("必须选择一条数据！");
			}
		};
	</script>
</body>
</html>