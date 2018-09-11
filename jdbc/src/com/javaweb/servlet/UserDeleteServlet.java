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
 * 删除用户信息
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserDeleteServlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取index.jsp页面传递的UserId
		long userid = Long.parseLong(request.getParameter("userid"));
		//调用service
		IBaseService<User> userservice = new IUserServiceImpl();
		Object param[] = {userid};
		userservice.delete(param);
        //数据更新后返回UserlistServlet 在进行处理，把所有的结果传递到index.jsp界面
		response.sendRedirect(request.getContextPath()+"/UserListServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}