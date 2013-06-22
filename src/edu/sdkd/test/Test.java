package edu.sdkd.test;

import java.sql.Connection;
import java.sql.SQLException;

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
}
