package edu.abc.clothshoppingmanager.dao;

public interface BaseDAO {
	//提取父接口，声明一些公共资源
	public String driverClass="com.mysql.jdbc.Driver";
	public String url="jdbc:mysql://localhost:3306/clothshop";
	public String username="root";
	public String password="root";
	
	public boolean add(Object o);
	
	public boolean  delete(Object id);
	
	public boolean update(Object  o);
	
	public Object    list();
}
