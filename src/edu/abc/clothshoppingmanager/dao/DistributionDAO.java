package edu.abc.clothshoppingmanager.dao;

import java.util.ArrayList;
import edu.abc.clothshoppingmanager.bean.Distribution;

public interface DistributionDAO extends BaseDAO {//这是物流管理DAO的父接口

	public ArrayList<Distribution> listALLDistribution();
	
	public ArrayList<Distribution> distributionClassify(int distribution);
	
	public ArrayList<Distribution> listDistributionByPage(int count,int page);
}