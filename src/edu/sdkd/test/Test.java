package edu.sdkd.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import edu.sdkd.datasource.MyDataSource;
import edu.sdkd.utils.Utils;

public class Test {
	MyDataSource dataSource = new MyDataSource();
	@org.junit.Test
	public void testConnection() throws SQLException{
		Connection connection = dataSource.getConnection();
		if(connection!=null)
			System.out.println("success");
	}
	
	@org.junit.Test
	public void testGetTime(){
		System.out.println(Utils.getCurrentTime());
	}
}
