package com.javaweb.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*
 * 管理员数据访问层实现类
 */
import java.util.List;

import com.javaweb.dao.IBaseDao;
import com.javaweb.pojo.Admin;
import com.javaweb.util.DBTools;
import com.javaweb.util.UpdateSqlTools;

public class IAdminDaoImpl extends UpdateSqlTools implements IBaseDao<Admin>{
    //因为管理员只需要查询 ，不用更新所以就先实现这一个方法
	@Override
	public List<Admin> query(String sql, Object[] param) {
		ResultSet set = (ResultSet) DBTools.getExcuteResult(sql, param);
		List<Admin> list = new ArrayList<Admin>();
		Admin admin = null;
		try {
			while(set.next()) {
				admin = new Admin();
				admin.setAdminname(set.getString("adminname"));
				admin.setAdminpassword(set.getString("adminpassword"));
				admin.setAdminid(set.getLong("adminid"));
				list.add(admin);
			}
		} catch (SQLException e) {
			System.out.println("无数据");
		}
		return list;
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

	@Override
	public List<Admin> query(Object... param) {
		return null;
	}

}