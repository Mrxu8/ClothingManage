package edu.abc.clothshoppingmanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import edu.abc.clothshoppingmanager.bean.Distribution;

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

	@Override
	public ArrayList<Distribution> listALLDistribution() {
		ArrayList<Distribution> d = new ArrayList<Distribution>();
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select * from distribution");
			while (rs.next()) {
				d.add(parsetResultToDistribution(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	//这是查询物流管理信息的方法
	@Override
	public ArrayList<Distribution> distributionClassify(int distribution) {
		ArrayList<Distribution> classify = new ArrayList<Distribution>();
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select * from distribution where distribution="+ distribution);
			while (rs.next()) {
				classify.add(parsetResultToDistribution(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classify;
	}

	//这是根据查询到数据库信息后加载到bean对象的方法，因为复用所以单写方法来调用
	public Distribution parsetResultToDistribution(ResultSet rs) {
		Distribution d = null;
		try {
			d = new Distribution();
			d.setGoodsid(rs.getInt("goodsid"));
			d.setGoodsimg(rs.getString("goodsimg"));
			d.setCount(rs.getInt("count"));
			d.setPrice(rs.getFloat("price"));
			d.setPricestate(rs.getInt("pricestate"));
			d.setDistribution(rs.getInt("distribution"));
			ArrayList<String> state = new ArrayList<String>();
			rs=getSta().executeQuery("select * from distributionstate where goodsid="+rs.getInt("goodsid"));
			while(rs.next()) {
				state.add(rs.getString("stateinfo"));
			}
			d.setDistributionstate(state);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	//这是根据网页传来页数和数量来查询数据库中的物流管理数据信息
	@Override
	public ArrayList<Distribution> listDistributionByPage(int count, int page) {
		ArrayList<Distribution> distributions=new ArrayList<Distribution>();
		PreparedStatement sta=null;
		ResultSet rs=null;
		try {
			sta=getPreSta("select * from distribution order by goodsid desc limit ?,?");
			sta.setInt(1, (page-1)*count);
			sta.setInt(2, count);
			rs=sta.executeQuery();
			while(rs.next()) {
				Distribution  dd=new Distribution();
				dd.setGoodsid(rs.getInt("goodsid"));
				dd.setGoodsimg(rs.getString("goodsimg"));
				dd.setCount(rs.getInt("count"));
				dd.setPrice(rs.getFloat("price"));
				dd.setPricestate(rs.getInt("pricestate"));
				dd.setDistribution(rs.getInt("distribution"));
				ArrayList<String> state = new ArrayList<String>();
				rs=getSta().executeQuery("select * from distributionstate where goodsid="+rs.getInt("goodsid"));
				while(rs.next()) {
					state.add(rs.getString("stateinfo"));
				}
				dd.setDistributionstate(state);
				distributions.add(dd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(sta, rs);
		return distributions;
	}
}