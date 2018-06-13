package edu.abc.clothshoppingmanager.dao;

import java.util.ArrayList;
import edu.abc.clothshoppingmanager.bean.Distribution;
import edu.abc.clothshoppingmanager.bean.DistributionGoods;

public interface DistributionDAO extends BaseDAO {//这是物流管理DAO的父接口
	
	public ArrayList<DistributionGoods> distributionClassify(int distribution);
	
	public ArrayList<Distribution> listDistributionByPage(int count,int page);
	
	public ArrayList<DistributionGoods> distributionByOrder(int orderid);
}