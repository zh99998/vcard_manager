package edu.sdkd.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Before;

import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.datasource.MyDataSource;
import edu.sdkd.utils.Utils;

public class Test {
	@org.junit.Test
	public void testConnection() throws SQLException{
		CardDao cardDao = new CardDaoImpl();
		System.out.print(cardDao.list());
	}
	
	@org.junit.Test
	public void testGetTime(){
		System.out.println(Utils.getCurrentTime());
	}
	
	@org.junit.Test
	public void testReadFile(){
		Properties properties=null;
		properties = Utils.readProperties("db.properties");
		System.out.println(properties.getProperty("driver"));
		System.out.println(properties.getProperty("url"));
		System.out.println(properties.getProperty("user"));
		System.out.println(properties.getProperty("password"));
	}
}
