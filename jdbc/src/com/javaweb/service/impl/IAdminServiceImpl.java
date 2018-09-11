package com.javaweb.service.impl;

import java.util.List;

import com.javaweb.dao.IBaseDao;
import com.javaweb.dao.impl.IAdminDaoImpl;
import com.javaweb.pojo.Admin;
import com.javaweb.service.IAdminService;

public class IAdminServiceImpl implements IAdminService {

	private IBaseDao<Admin> admindao = new IAdminDaoImpl();

	@Override
	public List<Admin> query(String sql, Object... param) {
		return this.admindao.query(sql, param);
	}

	@Override
	public List<Admin> query(Object... param) {
		return null;
	}

	@Override
	public boolean add(Admin t) {
		return false;
	}

	@Override
	public boolean update(Admin t) {
		return false;
	}

	@Override
	public boolean delete(Object... param) {
		return false;
	}

}
