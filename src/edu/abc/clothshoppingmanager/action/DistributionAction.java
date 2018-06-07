package edu.abc.clothshoppingmanager.action;

import java.util.ArrayList;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import edu.abc.clothshoppingmanager.bean.Distribution;
import edu.abc.clothshoppingmanager.dao.DistributionDAO;
import edu.abc.clothshoppingmanager.dao.DistributionDAOImp;
import edu.abc.clothshoppingmanager.util.Responser;

public class DistributionAction {//这是处理物流管理的所有方法

	private DistributionDAO dao;
	private DistributionAction d;
	private int count;
	private int page;
	private int distribution;
	
	public DistributionAction getD() {
		return d;
	}
	public void setD(DistributionAction d) {
		this.d = d;
	}
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
	
	
	//这里是通过接收快递公司分类进行查询信息
	public void classifyDistribution() {
		ArrayList<Distribution> distributions = dao.distributionClassify(distribution);
		String jsonResult = jsoninfo(distributions);
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), jsonResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//这是进行JSON数据封装给页面加载数据，因为在此页面复用所以单独写一个方法调用
	protected String jsoninfo(ArrayList<Distribution> distributions) {
		JSONArray js = new JSONArray();
		for(Distribution d: distributions) {
			try {
				JSONObject  j=new JSONObject();
				j.put("goodsid", d.getGoodsid());
				j.put("goodsimg", "<img src='"+d.getGoodsimg()+"'/>");
				j.put("count", d.getCount());
				j.put("price", d.getPrice());
				j.put("pricestate", d.getPricestate());
				j.put("distribution", d.getDistribution());
				j.put("distributionstate", d.getDistributionstate());
				js.put(j);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(js.toString());
		return js.toString();
	}
}