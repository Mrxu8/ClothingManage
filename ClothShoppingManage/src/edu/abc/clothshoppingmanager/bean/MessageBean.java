package edu.abc.clothshoppingmanager.bean;

public class MessageBean {
	
	private String id;
	private String msg;
	private String form;
	private String to;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	public MessageBean() {
		super();
	}
	
	public MessageBean(String id, String msg, String form, String to) {
		super();
		this.id = id;
		this.msg = msg;
		this.form = form;
		this.to = to;
	}
	
	
	
}
