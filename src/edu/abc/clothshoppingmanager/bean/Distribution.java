package edu.abc.clothshoppingmanager.bean;

import java.util.ArrayList;

public class Distribution {//这是物流管理的订单javabean

	private int orderid;
	private int userid;
	private float payment;
	private int paymenttype;
	private int status;
	private String note;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public float getPayment() {
		return payment;
	}
	public void setPayment(float payment) {
		this.payment = payment;
	}
	public int getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(int paymenttype) {
		this.paymenttype = paymenttype;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public Distribution() {
		super();
	}
	public Distribution(int orderid, int userid, float payment, int paymenttype, int status, String note) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.payment = payment;
		this.paymenttype = paymenttype;
		this.status = status;
		this.note = note;
	}
	
	@Override
	public String toString() {
		return "Distribution [orderid=" + orderid + ", userid=" + userid + ", payment=" + payment + ", paymenttype="
				+ paymenttype + ", status=" + status + ", note=" + note + "]";
	}
}