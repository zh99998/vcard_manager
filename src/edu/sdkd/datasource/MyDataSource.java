package edu.sdkd.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyDataSource {
	String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://zhang-pc:3306/vcard_manager";
	private static String user = "root";
	private static String password = "root";
	
	private static int initCount = 5;
	private static int maxCount = 100;
	private int currentCount = 0;
	LinkedList<Connection> connectionsPool = new LinkedList<Connection>();
	
	public MyDataSource() {
		for(int i=0;i<initCount;i++){
			try {
				this.connectionsPool.addLast(this.createConnection());
				this.currentCount++;
			} catch (SQLException e) {
				throw new ExceptionInInitializerError();
			}
		}
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection realConn = DriverManager.getConnection(url, user, password);
		MyConnectionHandler proxy = new MyConnectionHandler(this);
		return proxy.bind(realConn);
	}
}
