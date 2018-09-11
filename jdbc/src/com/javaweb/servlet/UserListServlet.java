package com.javaweb.servlet;

import java.io.IOException;
import java.util.List;

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
 * 查询用户列表信息
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserListServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用接口实例化实现类
		IBaseService<User> userservivce = new IUserServiceImpl();
        //这里有隐藏的sql语句 select * from user order by userid desc
		String param[] = {};
        //查询所有结果放入list
		List<User> list = userservivce.query(param);
		//通过session将list传递给jsp
		HttpSession session =  request.getSession();
        //list 命名为userlist
		session.setAttribute("userlist", list);
		response.sendRedirect("index.jsp");
	}

}