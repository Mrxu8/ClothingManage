package edu.abc.clothshoppingmanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.abc.clothshoppingmanager.bean.ManagerBean;

public class ManagerDaoImp extends BaseDAOImp implements ManagerDao{

	@Override
	public boolean add(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagerBean login(String username, String password) {
		// TODO Auto-generated method stub
		ManagerBean manager=null;
		PreparedStatement  sta=null;
		ResultSet rs=null;
		try {
			sta=getPreSta("select *  from manager where manager_name=? and manager_pwd=?");
			sta.setString(1, username);
			sta.setString(2, password);
			rs=sta.executeQuery();
			if(rs.next()) {
				manager=new ManagerBean();
				manager.setManager_id(rs.getInt("manager_id"));
				manager.setManager_img(rs.getString("manager_img"));
				manager.setManager_name(rs.getString("manager_name"));
				manager.setManager_nickname(rs.getString("manager_nickname"));
				manager.setManager_power(rs.getString("manager_power"));
				manager.setManager_pwd(rs.getString("manager_pwd"));
				manager.setManager_tel(rs.getString("manager_tel"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return manager;
	}

}
