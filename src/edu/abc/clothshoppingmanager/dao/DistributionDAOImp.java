package edu.abc.clothshoppingmanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import edu.abc.clothshoppingmanager.bean.Distribution;
import edu.abc.clothshoppingmanager.bean.DistributionGoods;

//这里是物流管理DAO的实现方法类
public class DistributionDAOImp extends BaseDAOImp implements DistributionDAO {

	@Override
	public boolean add(Object o) {
		return false;
	}

	@Override
	public boolean delete(Object id) {
		return false;
	}

	@Override
	public boolean update(Object o) {
		return false;
	}

	@Override
	public Object list() {
		return null;
	}


	//这是根据物流商家查询商品物流信息的方法
	@Override
	public ArrayList<DistributionGoods> distributionClassify(int distribution) {
		System.out.println("distribution="+distribution);
		ArrayList<DistributionGoods> classify = new ArrayList<DistributionGoods>();
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select * from order_goods where distribution="+ distribution+" order by order_id desc");
			while (rs.next()) {
				classify.add(parsetResultToDistributionGoods(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classify;
	}
	
	//这是根据查看页面加载订单的信息
	@Override
	public ArrayList<DistributionGoods> distributionByOrder(int orderid) {
		ArrayList<DistributionGoods> distributions=new ArrayList<DistributionGoods>();
		PreparedStatement sta=null;
		ResultSet rs=null;
		try {
			sta=getPreSta("select * from order_goods where order_id="+orderid+" order by goods_id desc");
			rs=sta.executeQuery();
			while(rs.next()) {
				distributions.add(parsetResultToDistributionGoods(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(sta, rs);
		return distributions;
	}
	
	//这是根据网页传来页数和数量来查询数据库中的物流管理数据信息
	@Override
	public ArrayList<Distribution> listDistributionByPage(int count, int page) {
		System.out.println("count="+count+",page="+page);
		ArrayList<Distribution> distributions=new ArrayList<Distribution>();
		PreparedStatement sta=null;
		ResultSet rs=null;
		try {
			sta=getPreSta("select * from ordertable order by order_id desc limit "+(page-1)*count+" ,"+count);
			rs=sta.executeQuery();
			while(rs.next()) {
				distributions.add(parsetResultToDistributionOrder(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(sta, rs);
		return distributions;
	}

	//这是根据查询到数据库信息后加载订单商品bean到一个对象的方法，因为复用所以单写开来调用
	public DistributionGoods parsetResultToDistributionGoods(ResultSet rs) {
		DistributionGoods d = null;
		try {
			d = new DistributionGoods();
			d.setOrdersid(rs.getInt("order_id"));
			d.setGoodsid(rs.getInt("goods_id"));
			d.setGoodsname(rs.getString("goods_name"));
			d.setPicture(rs.getString("picture"));
			d.setPrice(rs.getFloat("price"));
			d.setCount(rs.getInt("num"));
			d.setTotal(d.getPrice()*d.getCount());
			d.setDistribution(rs.getInt("distribution"));
			d.setDistributions(rs.getString("distributions"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	//这是根据查询到数据库信息后加载订单bean到一个对象的方法，因为复用所以单写开来调用
	public Distribution parsetResultToDistributionOrder(ResultSet rs) {
		Distribution d = null;
		try {
			d = new Distribution();
			d.setOrderid(rs.getInt("order_id"));
			d.setUserid(rs.getInt("order_userid"));
			d.setPayment(rs.getFloat("payment"));
			d.setPaymenttype(rs.getInt("payment_type"));
			d.setStatus(rs.getInt("status"));
			d.setNote(rs.getString("user_note"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
}