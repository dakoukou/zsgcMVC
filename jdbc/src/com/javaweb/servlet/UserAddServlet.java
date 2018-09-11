package com.javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.pojo.User;
import com.javaweb.service.IBaseService;
import com.javaweb.service.impl.IUserServiceImpl;

/**
 * 添加用户信息
 */
@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserAddServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");// 用户名
		String password = request.getParameter("password");// 密码
		// 1.实例化service
		IBaseService<User> userservice = new IUserServiceImpl();
		// 2.实例化用户
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		// 调用添加方法
		userservice.add(user);
		// 添加成功后跳转到了查询用户列表页面
		response.sendRedirect("UserListServlet");
	}

}