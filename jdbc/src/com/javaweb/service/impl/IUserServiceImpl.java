package com.javaweb.service.impl;

import java.util.List;

import com.javaweb.dao.IBaseDao;
import com.javaweb.dao.impl.IUserDaoImpl;
import com.javaweb.pojo.User;
import com.javaweb.service.IBaseService;

/**
 * 用户业务逻辑实现类
 * 
 */
public class IUserServiceImpl implements IBaseService<User> {
	//使用接口实例化实现类
	private IBaseDao<User> userdao = new IUserDaoImpl();

	@Override
	public List<User> query(Object... param) {
		return this.userdao.query(param);
	}

	@Override
	public List<User> query(String Sql, Object... param) {
		return this.userdao.query(Sql,param);
	}

	@Override
	public boolean add(User user) {
		return this.userdao.add(user);
	}

	@Override
	public boolean update(User user) {
		return this.userdao.update(user);
	}

	@Override
	public boolean delete(Object... param) {
		return this.userdao.delete(param);
	}

}
