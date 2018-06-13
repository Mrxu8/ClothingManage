package edu.abc.clothshoppingmanager.action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import edu.abc.clothshoppingmanager.bean.Distribution;
import edu.abc.clothshoppingmanager.bean.DistributionGoods;
import edu.abc.clothshoppingmanager.dao.DistributionDAO;
import edu.abc.clothshoppingmanager.dao.DistributionDAOImp;
import edu.abc.clothshoppingmanager.util.Responser;

public class DistributionAction {//这是处理物流管理的所有方法

	private DistributionDAO dao;
	private DistributionAction d;
	private int count;
	private int page;
	private int orderid;
	private int distribution;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getDistribution() {
		return distribution;
	}
	public void setDistribution(int distribution) {
		this.distribution = distribution;
	}
	public DistributionAction() {
		dao = new DistributionDAOImp();
	}

	
	//这是通过网页接收要查看的页数和数量来查询信息
	public void listDistributionByPage() {
		ArrayList<Distribution> distributions = dao.listDistributionByPage(count, page);
		String jsonResult = jsoninfo(distributions);
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), jsonResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//这是通过数据表格得到子表格的数据信息
	public void distributionByOrder() {
		System.out.println("orderid="+orderid);
		ArrayList<DistributionGoods> distributions = dao.distributionByOrder(orderid);
		String jsonResult = jsonGoodsinfo(distributions);
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), jsonResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//这里是通过接收快递公司分类进行查询信息
	public void classifyDistribution() {
		ArrayList<DistributionGoods> distributions = dao.distributionClassify(distribution);
		System.out.println(distribution);
		String jsonResult = jsonClassifyinfo(distributions);
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), jsonResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//这是进行JSON数据封装给页面加载数据，普通的分页查看信息方法将调用此方法
	protected String jsoninfo(ArrayList<Distribution> distributions) {
		JSONArray js = new JSONArray();
		for(Distribution d: distributions) {
			try {
				JSONObject  j=new JSONObject();
				j.put("order_id", d.getOrderid());
				j.put("user_id", d.getUserid());
				
				//这段代码是将数据库得到的付款金额转成2位小数后存入JSON数据
				String a = new DecimalFormat("###,###,###,###.##").format(100.12345);
				float scale = d.getPayment();
				DecimalFormat fnum = new DecimalFormat("##0.00");
				String dd = fnum.format(scale);//
				
				j.put("payment", dd);
				j.put("status", (d.getStatus()==0)?"未付款":"已付款");
				if (d.getPaymenttype()==1) {
					j.put("payment_type", "支付宝");
				}else if (d.getPaymenttype()==2) {
					j.put("payment_type", "翼支付");
				}else if (d.getPaymenttype()==3) {
					j.put("payment_type", "微信钱包");
				}else if (d.getPaymenttype()==4) {
					j.put("payment_type", "短信支付");
				}else if (d.getPaymenttype()==5) {
					j.put("payment_type", "银行卡支付");
				}else {
					j.put("payment_type", "货到付款");
				}
				j.put("note", d.getNote());
				js.put(j);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(js.toString());
		return js.toString();
	}
	
	//这是进行JSON数据封装给页面加载数据，普通的分页查看信息方法将调用此方法
		protected String jsonGoodsinfo(ArrayList<DistributionGoods> distributions) {
			JSONArray js = new JSONArray();
			for(DistributionGoods d: distributions) {
				try {
					JSONObject j=new JSONObject();
					j.put("goods_id", d.getGoodsid());
					j.put("goods_name", d.getGoodsname());
					j.put("picture", d.getPicture());
					//这段代码是将数据库得到的付款金额转成2位小数后存入JSON数据
					String a = new DecimalFormat("###,###,###,###.##").format(100.12345);
					DecimalFormat fnum = new DecimalFormat("##0.00");
					j.put("price", fnum.format(d.getPrice()));
					j.put("count", d.getCount());
					j.put("total", fnum.format(d.getTotal()));
					if (d.getDistribution()==1) {
						j.put("distribution", "顺丰快递");
					}else if (d.getDistribution()==2) {
						j.put("distribution", "中通快递");
					}else if (d.getDistribution()==3) {
						j.put("distribution", "韵达快递");
					}else if (d.getDistribution()==4) {
						j.put("distribution", "圆通快递");
					}else if (d.getDistribution()==5) {
						j.put("distribution", "申通快递");
					}else {
						j.put("distribution", "EMS");
					}
					j.put("distributions", d.getDistributions());
					js.put(j);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println(js.toString());
			return js.toString();
		}
	
	//这是进行JSON数据封装给页面加载数据，分类查看信息方法将调用此方法
		protected String jsonClassifyinfo(ArrayList<DistributionGoods> distributions) {
			JSONArray js = new JSONArray();
			for(DistributionGoods d: distributions) {
				try {
					JSONObject  j=new JSONObject();
					j.put("order_id", d.getOrdersid());
					j.put("goods_id", d.getGoodsid());
					j.put("goods_name", d.getGoodsname());
					j.put("picture", d.getPicture());
					//这段代码是将数据库得到的付款金额转成2位小数后存入JSON数据
					String a = new DecimalFormat("###,###,###,###.##").format(100.12345);
					DecimalFormat fnum = new DecimalFormat("##0.00");
					j.put("price", fnum.format(d.getPrice()));
					j.put("count", d.getCount());
					j.put("total", fnum.format(d.getTotal()));
					if (d.getDistribution()==1) {
						j.put("distribution", "顺丰快递");
					}else if (d.getDistribution()==2) {
						j.put("distribution", "中通快递");
					}else if (d.getDistribution()==3) {
						j.put("distribution", "韵达快递");
					}else if (d.getDistribution()==4) {
						j.put("distribution", "圆通快递");
					}else if (d.getDistribution()==5) {
						j.put("distribution", "申通快递");
					}else {
						j.put("distribution", "EMS");
					}
					j.put("distributions", d.getDistributions());
					js.put(j);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println(js.toString());
			return js.toString();
		}
}