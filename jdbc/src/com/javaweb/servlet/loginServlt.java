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

import com.javaweb.pojo.Admin;
import com.javaweb.service.IBaseService;
import com.javaweb.service.impl.IAdminServiceImpl;

/**
 * 
 */
@WebServlet("/loginServlt")
public class loginServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}
    
    @Override
    public void init() throws ServletException {
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用接口实例化实现类
		IBaseService<Admin> adminservice = new IAdminServiceImpl();
        //获取login.jsp界面上的管理员用户名和密码
		String adminname = request.getParameter("adminname");
		String adminpwd = request.getParameter("adminpassword");
		System.out.println(adminname);
		System.out.println(adminpwd);
        //查询语句
		String sql = "select * from admin where adminname=? and adminpassword=?";
		String [] param = {adminname,adminpwd};
        //将查询结果放入list
		List<Admin> list = adminservice.query(sql, param);
		System.out.println(list.get(0).getAdminname());
		//session
		HttpSession session = request.getSession();
        //size>0 说明有数据 进行跳转
		if(list.size()>0) {
			Long adminid = list.get(0).getAdminid();
			session.setAttribute("login_adminid", adminid);
			session.setAttribute("Adminname", list.get(0).getAdminname());
			//跳转到读取用户列表的servlet
			response.sendRedirect("UserListServlet");
		}else {
			session.setAttribute("login_adminid", 0);
			response.sendRedirect("login.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}