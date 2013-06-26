package edu.sdkd.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

import edu.sdkd.utils.Utils;

public class MyDataSource {
	
	private static Properties properties = Utils.readProperties("db.properties");
	
	private static String driver = properties.getProperty("driver");
	private static String url = properties.getProperty("url");
	private static String user = properties.getProperty("user");
	private static String password = properties.getProperty("password");
	
	private static int initCount = Integer.valueOf(properties.getProperty("initCount"));
	private static int maxCount = Integer.valueOf(properties.getProperty("maxCount"));
	private static int currentCount = Integer.valueOf(properties.getProperty("currentCount"));
	
	LinkedList<Connection> connectionsPool = new LinkedList<Connection>();
	
	{
		for(int i=0;i<initCount;i++){
			try {
				this.connectionsPool.addLast(this.createConnection());
				this.currentCount++;
			} catch (SQLException e) {
				throw new ExceptionInInitializerError();
			}
		}
	}
	private static final MyDataSource myDataSource = new MyDataSource();
	private MyDataSource(){
		
	}
	
	public static MyDataSource getMyDataSource(){
		return myDataSource;
	}
	
	public Connection getConnection() throws SQLException{
		synchronized(connectionsPool){
			if(this.connectionsPool.size()>0)
				return this.connectionsPool.removeFirst();
			if(this.currentCount<this.maxCount){
				this.currentCount++;
				return this.createConnection();
			}	
			throw new SQLException("已没有连接");
		}
	}
	
	public void free(Connection conn){
		this.connectionsPool.addLast(conn);
	}
	
	private Connection createConnection() throws SQLException{
		try {
			Class.forName(driver);
			Connection realConn = DriverManager.getConnection(url, user, password);
			MyConnectionHandler proxy = new MyConnectionHandler(this);
			return proxy.bind(realConn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
