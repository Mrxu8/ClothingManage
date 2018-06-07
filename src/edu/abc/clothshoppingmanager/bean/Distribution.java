package edu.abc.clothshoppingmanager.bean;

import java.util.ArrayList;

public class Distribution {//这是物流管理的javabean

	private int goodsid;
	private String goodsimg;
	private int count;
	private float price;
	private int pricestate;
	private int distribution;
	private ArrayList<String> distributionstate;
	
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsimg() {
		return goodsimg;
	}
	public void setGoodsimg(String goodsimg) {
		this.goodsimg = goodsimg;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getPricestate() {
		return pricestate;
	}
	public void setPricestate(int pricestate) {
		this.pricestate = pricestate;
	}
	public int getDistribution() {
		return distribution;
	}
	public void setDistribution(int distribution) {
		this.distribution = distribution;
	}
	public ArrayList<String> getDistributionstate() {
		return distributionstate;
	}
	public void setDistributionstate(ArrayList<String> distributionstate) {
		this.distributionstate = distributionstate;
	}
	
	public Distribution() {
		super();
	}
	public Distribution(int goodsid, String goodsimg, int count, float price, int pricestate, int distribution,
			ArrayList<String> distributionstate) {
		super();
		this.goodsid = goodsid;
		this.goodsimg = goodsimg;
		this.count = count;
		this.price = price;
		this.pricestate = pricestate;
		this.distribution = distribution;
		this.distributionstate = distributionstate;
	}
	
	@Override
	public String toString() {
		return "Distribution [goodsid=" + goodsid + ", goodsimg=" + goodsimg + ", count=" + count + ", price=" + price
				+ ", pricestate=" + pricestate + ", distribution=" + distribution + ", distributionstate="
				+ distributionstate + "]";
	}
}