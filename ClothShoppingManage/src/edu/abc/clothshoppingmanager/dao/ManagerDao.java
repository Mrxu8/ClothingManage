package edu.abc.clothshoppingmanager.dao;

import edu.abc.clothshoppingmanager.bean.ManagerBean;

public interface ManagerDao {
	
	//管理员登录方法
	public ManagerBean login(String username,String password);

}
