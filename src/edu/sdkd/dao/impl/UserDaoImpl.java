package edu.sdkd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.sdkd.dao.DaoException;
import edu.sdkd.dao.UserDao;
import edu.sdkd.datasource.MyDataSource;
import edu.sdkd.domain.User;

public class UserDaoImpl implements UserDao {

	public User find(String name, String password) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			User user = new User();
			String sql = "select id,name,password,admin from user where name=? and password=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2,password);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setAdmin(rs.getBoolean("admin"));
			}
			return user;
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			dataSource.free(conn);
		}
	}

	//modify password
	public void modifyPassword(int id,String newPassword) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "update user  set password=? where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.executeUpdate();
		} catch (SQLException e){
			throw new DaoException(e.getMessage(), e);
		}finally {
			dataSource.free(conn);
		}
	}

}
