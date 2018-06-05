package edu.abc.clothshoppingmanager.bean;

public class ManagerBean {
	
	private int manager_id;
	private String manager_name;
	private String manager_nickname;
	private String manager_pwd;
	private String manager_tel;
	private String manager_img;
	private String manager_power;
	private String create_date;
	
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_nickname() {
		return manager_nickname;
	}
	public void setManager_nickname(String manager_nickname) {
		this.manager_nickname = manager_nickname;
	}
	public String getManager_pwd() {
		return manager_pwd;
	}
	public void setManager_pwd(String manager_pwd) {
		this.manager_pwd = manager_pwd;
	}
	public String getManager_tel() {
		return manager_tel;
	}
	public void setManager_tel(String manager_tel) {
		this.manager_tel = manager_tel;
	}
	public String getManager_img() {
		return manager_img;
	}
	public void setManager_img(String manager_img) {
		this.manager_img = manager_img;
	}
	public String getManager_power() {
		return manager_power;
	}
	public void setManager_power(String manager_power) {
		this.manager_power = manager_power;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	
	public ManagerBean() {
		super();
	}
	public ManagerBean(int manager_id, String manager_name, String manager_nickname, String manager_pwd,
			String manager_tel, String manager_img, String manager_power, String create_date) {
		super();
		this.manager_id = manager_id;
		this.manager_name = manager_name;
		this.manager_nickname = manager_nickname;
		this.manager_pwd = manager_pwd;
		this.manager_tel = manager_tel;
		this.manager_img = manager_img;
		this.manager_power = manager_power;
		this.create_date = create_date;
	}
	@Override
	public String toString() {
		return "ManagerBean [manager_id=" + manager_id + ", manager_name=" + manager_name + ", manager_nickname="
				+ manager_nickname + ", manager_pwd=" + manager_pwd + ", manager_tel=" + manager_tel + ", manager_img="
				+ manager_img + ", manager_power=" + manager_power + ", create_date=" + create_date + "]";
	}
	
	
	
}
