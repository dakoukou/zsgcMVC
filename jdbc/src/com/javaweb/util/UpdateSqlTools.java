package com.javaweb.util;

/**
 * 更新操作工具
 */
public class UpdateSqlTools {

	public static boolean operation(int num) {
		boolean b = false;
		if(num>0) {
			b=true;
		}else {
			b=false;
		}
		return b;
	}
}
