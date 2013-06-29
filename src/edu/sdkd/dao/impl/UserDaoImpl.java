package edu.sdkd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			System.out.println("+++++++++++1");
			conn = dataSource.getConnection();
			System.out.println("+++++++++++2");
			
			String sql = "select id,name,password,admin from user where name=? and password=?;";
			ps = conn.prepareStatement(sql);
			System.out.println("+++++++++++3");
			ps.setString(1, name);
			ps.setString(2,password);
			rs = ps.executeQuery();
			System.out.println("+++++++++++4");
			if (rs.next()) {
				User user = new User();
				System.out.println("++++++++++5");
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setAdmin(rs.getBoolean("admin"));
				System.out.println(user.getId());
				System.out.println("+++++++++++");
				return user;
			}else {
				return null;
			}
			
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
	
	public ArrayList<User> showUserList() {
		// 从数据库中检索到了符合条件的数据，然后把它们放到实例化user对象中，然后在放到链表中返回，然后发送到前台遍历
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		User user = null;
		ArrayList<User> list = new ArrayList<User>();
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT name,password,id,admin FROM user;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setAdmin(rs.getBoolean("admin"));

				list.add(user);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 执行完关闭数据库
			dataSource.free(conn);
		}
		return list;
	}

	public void addUser(String name, String password) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into user (name,password) values(?,?)  ";
			ps = conn.prepareStatement(sql);

			ps.setString(1, name);
			ps.setString(2, password);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			dataSource.free(conn);
		}
	}

	public void deleteUser(int id) {
		
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		
		PreparedStatement ps = null;
		try {
			
			conn = dataSource.getConnection();
			
			String sql = "delete from user where id=?;";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			dataSource.free(conn);
		}
	}
	  public void updateUser(String name,String password ,int id){
		    MyDataSource dataSource = MyDataSource.getMyDataSource();
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				
				conn = dataSource.getConnection();
				String sql = "UPDATE user SET name=? ,password=? WHERE id=?;";
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, name);
				ps.setString(2, password);
				ps.setInt(3, id);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				throw new DaoException(e.getMessage(), e);
			} finally {
				dataSource.free(conn);
			}
	}

}
