package com.javaweb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.dao.IBaseDao;
import com.javaweb.pojo.User;
import com.javaweb.util.DBTools;
import com.javaweb.util.UpdateSqlTools;

/**
 * 用户数据访问层实现类
 */
public class IUserDaoImpl extends UpdateSqlTools implements IBaseDao<User> {

	@Override
    //查询
	public List<User> query(Object... param) {
		String sql = "select * from user order by userid desc";
		ResultSet set = (ResultSet) DBTools.getExcuteResult(sql, param);
		List<User> list = new ArrayList<User>();
		User user = null;
		try {
			while(set.next()) {
				user = new User();
				user.setUsername(set.getString("username"));
				user.setPassword(set.getString("password"));
				user.setUserid(set.getLong("userid"));
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println("无数据");
		}
		return list;
	}
    
	//带SQL语句的查询
	public List<User> query(String sql,Object... param) {
		ResultSet set = (ResultSet) DBTools.getExcuteResult(sql, param);
		List<User> list = new ArrayList<User>();
		User user = null;
		try {
			while(set.next()) {
				user = new User();
				user.setUsername(set.getString("username"));
				user.setPassword(set.getString("password"));
				user.setUserid(set.getLong("userid"));
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println("无数据");
		}
		return list;
	}
    
   //添加
	@Override
	public boolean add(User user) {
		
		String sql = "insert into user(username,password)"
				+ "values(?,?)";
		Object[] param = {user.getUsername(),user.getPassword()};
		int num = (int) DBTools.getExcuteResult(sql, param);
		return super.operation(num);
	}
    
   // 修改
	@Override
	public boolean update(User user) {
		String sql = "update user set username=?,password=? where userid=?";
		Object[] param = {user.getUsername(),user.getPassword(),user.getUserid()};
		int num = (int) DBTools.getExcuteResult(sql, param);
		return super.operation(num);
	}

    //删除
	@Override
	public boolean delete(Object... param) {
		String sql = "delete from user where userid =?";
		int num = (int) DBTools.getExcuteResult(sql, param);
		return super.operation(num);
	}

}