package edu.sdkd.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import edu.sdkd.datasource.MyDataSource;

public class DBCTest {
	MyDataSource dataSource = new MyDataSource();
	@Test
	public void testConnection() throws SQLException{
		Connection connection = dataSource.getConnection();
		if(connection!=null)
			System.out.println("success");
	}
}
