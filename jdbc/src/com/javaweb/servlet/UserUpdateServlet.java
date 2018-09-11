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
 * 用户数据修改
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserUpdateServlet() {
        super();
    }
public void init(ServletConfig config) throws ServletException {
	}


	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");// 用户名
		String password = request.getParameter("password");// 密码
		long userid = Long.parseLong(request.getParameter("userid"));
		//1.实例化service
		IBaseService<User> userservice = new IUserServiceImpl();
		//2.实例化用户
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setUserid(userid);
		//调用service的修改方法进行修改
		userservice.update(user);
		//跳转到列表查询的servlet可以查看到更新过的数据
		response.sendRedirect(request.getContextPath()+"/UserListServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}