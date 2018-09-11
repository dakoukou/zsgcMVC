package com.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaweb.pojo.User;
import com.javaweb.service.IBaseService;
import com.javaweb.service.impl.IUserServiceImpl;

/**
 * 跳转到修改用户信息
 * 
 */
@SuppressWarnings("serial")
@WebServlet("/UserToUpdateServlet")
public class UserToUpdateServlet extends HttpServlet {
	public UserToUpdateServlet() {
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//跳转到修改页面时，需要首先获取到要修改的数据
		//即：通过主键查询出来该条数据的内容
		long userid = Long.parseLong(req.getParameter("userid"));
		System.out.println(userid);
		Object param[] = {userid};
		String sql = "select * from user where userid = ?";
		//实例化service
		IBaseService<User> userservice = new IUserServiceImpl();
		User user = userservice.query(sql, param).get(0);
		//通过session把数据共享到下一页面
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
		//req.getContextPath()获取到项目目录->EL:pageContext.request.contextPath
		resp.sendRedirect(req.getContextPath()+"/admin/user/user_update.jsp");
	}
}