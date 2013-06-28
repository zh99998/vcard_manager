package edu.sdkd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.sdkd.dao.CircleDao;
import edu.sdkd.dao.DaoException;
import edu.sdkd.datasource.MyDataSource;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Circle;

public class CircleDaoImpl implements CircleDao{
	public void addCircle(Circle circle) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into Circle(created_at,updated_at,name)values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(System.currentTimeMillis()));
			ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			ps.setString(3, circle.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			dataSource.free(conn);
		}
	}
	
	public void delete(Circle circle) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		Statement st = null;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from circle  where id=" + circle.getId();
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e){
			throw new DaoException(e.getMessage(), e);
		}finally {
			dataSource.free(conn);
		}
	}

	public Circle getCircle(int id) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Circle circle = new Circle();
		try {
			conn = dataSource.getConnection();
			String sql = "select * from circle  where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				circle = mappingCircle(rs);
			}
		} catch (SQLException e){
			throw new DaoException(e.getMessage(), e);
		}finally {
			dataSource.free(conn);
		}
		return circle;
	}

	private Circle mappingCircle(ResultSet rs) throws SQLException {
		Circle circle = new Circle();
		circle.setId(rs.getInt("id"));
		circle.setCreatedAt(rs.getDate("created_at"));
		circle.setUpdatedAt(rs.getDate("updated_at"));
		circle.setName(rs.getString("name"));
		circle.setDeleted(rs.getBoolean("deleted"));
        return circle;
	}

	public void update(Circle circle) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "update circle  set name=? where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setString (1, circle.getName());
			ps.setInt (2, circle.getId());
			ps.executeUpdate();
		} catch (SQLException e){
			throw new DaoException(e.getMessage(), e);
		}finally {
			dataSource.free(conn);
		}
	}
	
	public List<Circle> list(){
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		List listCircle = new ArrayList<Circle>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			Circle circle = new Circle();
			String sql = "select * from circle";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				circle = mappingCircle(rs);
				listCircle.add(circle);
			}
		} catch (SQLException e){
			throw new DaoException(e.getMessage(), e);
		}finally {
			dataSource.free(conn);
		}
		return listCircle;
	}

	
}
