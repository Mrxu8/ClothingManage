package edu.abc.clothshoppingmanager.action;

import org.apache.struts2.ServletActionContext;

import edu.abc.clothshoppingmanager.bean.ManagerBean;
import edu.abc.clothshoppingmanager.dao.ManagerDao;
import edu.abc.clothshoppingmanager.dao.ManagerDaoImp;
import edu.abc.clothshoppingmanager.uti.MD5;

public class ManagerAction {
	
	private ManagerBean manager;
	private ManagerDao dao;
	
	
	
	public ManagerBean getManager() {
		return manager;
	}
	public void setManager(ManagerBean manager) {
		this.manager = manager;
	}

	public ManagerAction() {
		dao=new ManagerDaoImp();
	}
	/*
	 * 处理登录的方法
	 */
	public String login() {
		System.out.println("进入到action后台判断登陆的方法了");
		System.out.println(manager.getManager_name()+"\t"+manager.getManager_pwd());
		ManagerBean managers=dao.login(manager.getManager_name().trim(), MD5.MD5(manager.getManager_pwd()));
		if(managers!=null) {
			//将查询到的登录用户信息存储session中
			ServletActionContext.getRequest().getSession().setAttribute("managers", managers);
			return "success";
		}else {
			return "fail";
		}
	}
	/*
	 * 处理注销的方法
	 */
	public String logOut() {
		ServletActionContext.getRequest().getSession().removeAttribute("managers");
		return "fail";
	}
}
