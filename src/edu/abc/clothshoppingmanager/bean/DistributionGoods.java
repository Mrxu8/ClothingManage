package edu.abc.clothshoppingmanager.bean;

public class DistributionGoods {//这是物流管理的商品javabean

	private int ordersid;
	private int goodsid;
	private String goodsname;
	private String picture;
	private float price;
	private int count;
	private float total;
	private int distribution;
	private String distributions;
	
	public int getOrdersid() {
		return ordersid;
	}
	public void setOrdersid(int ordersid) {
		this.ordersid = ordersid;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getDistribution() {
		return distribution;
	}
	public void setDistribution(int distribution) {
		this.distribution = distribution;
	}
	public String getDistributions() {
		return distributions;
	}
	public void setDistributions(String distributions) {
		this.distributions = distributions;
	}
	
	public DistributionGoods() {
		super();
	}
	public DistributionGoods(int ordersid, int goodsid, String goodsname, String picture, float price, int count,
			float total, int distribution, String distributions) {
		super();
		this.ordersid = ordersid;
		this.goodsid = goodsid;
		this.goodsname = goodsname;
		this.picture = picture;
		this.price = price;
		this.count = count;
		this.total = total;
		this.distribution = distribution;
		this.distributions = distributions;
	}
	
	@Override
	public String toString() {
		return "DistributionGoods [ordersid=" + ordersid + ", goodsid=" + goodsid + ", goodsname=" + goodsname
				+ ", picture=" + picture + ", price=" + price + ", count=" + count + ", total=" + total
				+ ", distribution=" + distribution + ", distributions=" + distributions + "]";
	}
}
