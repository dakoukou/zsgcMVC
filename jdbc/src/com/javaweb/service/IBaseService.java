package com.javaweb.service;

import java.util.List;

/**
 * 通用的基本业务逻辑
 *  @param <T>
 */
public interface IBaseService<T> {
	/**
	 * 查询
	 * 
	 * @param param
	 * @return
	 */
	public List<T> query(Object... param);
	
	/**
	 * 带sql的操作
	 * @param Sql
	 * @param param
	 * @return
	 */
	public List<T> query(String Sql,Object ...param);

	/**
	 * 添加
	 * 
	 * @param param
	 * @return
	 */
	public boolean add(T t);

	/**
	 * 修改
	 * 
	 * @param param
	 * @return
	 */
	public boolean update(T t);

	/**
	 * 删除
	 * 
	 * @param param
	 * @return
	 */
	public boolean delete(Object... param);
}
