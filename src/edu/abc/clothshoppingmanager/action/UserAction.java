package edu.abc.clothshoppingmanager.action;

import edu.abc.clothshoppingmanager.bean.Users;
import edu.abc.clothshoppingmanager.dao.Userdaoimp;

public class UserAction {
	
	private Users u;
	private Userdaoimp dao=new Userdaoimp();
	public Users getU() {
		return u;
	}
	public void setU(Users u) {
		this.u = u;
	}

	/*
	 * 处理登录的方法
	 */
	public String login() {
		System.out.println("进入到action后台判断登陆的方法了");
		System.out.println(u.getAccount()+"\t"+u.getPassword());
		if(u.getAccount().equals("admin")&&u.getPassword().equals("123456")) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	/*
	 * 处理注销的方法
	 */
	public String logout() {
		System.out.println("进入注销登录");
		return null;
	}
	/*
	 * 处理后台查询所有客户的方法
	 */
	public void listalluser(){
		
	}
}

