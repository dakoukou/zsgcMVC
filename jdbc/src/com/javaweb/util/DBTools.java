package com.javaweb.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 数据库操作工具
 */
public class DBTools {
	// 创建连接地址
	private static final String url = "jdbc:mysql://localhost:3306/你的数据库名字?useUnicode=true&characterEncoding=utf8";
	// 创建用户名
	private static final String name = "数据库名字";
	private static final String pwd = "数据库密码";

	// 驱动包
	private static final String dpg = "com.mysql.jdbc.Driver";
	// 创建连接
	private static Connection conn = null;
	// 创建就绪状态
	private static PreparedStatement psmt = null;
	// 创建结果集
	private static ResultSet set = null;
	
	private static final String Error = "空返回值异常";

	// 连接数据库
	public static void getConnection() {
		try {
			Class.forName(dpg);
			conn = (Connection) DriverManager.getConnection(url, name, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动包有问题");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("密码错误/数据库没创建");
			e.printStackTrace();
		}

	}

	/*
	 * 通用的查询操作
	 */
	public static Object getExcuteResult(String sql, Object... pram) {
		// 创建连接
		getConnection();
		try {
			psmt = (PreparedStatement) conn.prepareStatement(sql);
			if (pram != null) {
				// for(Object obj:param)
				for (int i = 0; i < pram.length; i++) {
					// pstm.setObject(这是第几个问号, “参数内容”);
					psmt.setObject(i + 1, pram[i]);
				}
			} else {
				System.out.println("没SQL语句");
			}

			// .execute(); 用来判断是否是查询操作,无论是否查询操作，都将执行
			boolean b = psmt.execute();
			System.out.println(b);
			if (b) {
				//获取到get
				set = psmt.getResultSet();
				return set;
			} else {
				System.out.println("不是查询操作，执行更新操作");
				// 用来执行更新操作，返回值int
				// 获取执行更新操作的数量
				int num = psmt.getUpdateCount();
				return num;
			}

		} catch (SQLException e) {
			System.out.println("sql有错，请检查sql语句");
			e.printStackTrace();
			return Error;
		}

	}
	

	// 关闭数据图连接，状态，结果集
	public static void closeAll() {
		try {
			if (conn != null) {

				conn.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (set != null) {
				set.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}