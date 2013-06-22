package edu.sdkd.datasource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

class MyConnectionHandler implements InvocationHandler {

	private Connection realConnection;
	private Connection warpedConnection;
	private MyDataSource dataSource;
	
	MyConnectionHandler(MyDataSource dataSource) {
		this.dataSource = dataSource;
	}

	Connection bind(Connection realConn) {
		this.realConnection = realConn;
		this.warpedConnection = (Connection)Proxy.newProxyInstance(this.getClass().getClassLoader(),
				new Class[] { Connection.class }, this);
		return warpedConnection;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if("close".equals(method.getName())){
			this.dataSource.connectionsPool.addLast(this.warpedConnection);
		}
		return method.invoke(this.realConnection, args);
	}

}
