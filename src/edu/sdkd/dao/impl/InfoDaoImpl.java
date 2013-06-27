package edu.sdkd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.sdkd.dao.DaoException;
import edu.sdkd.dao.InfoDao;
import edu.sdkd.datasource.MyDataSource;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Info;

public class InfoDaoImpl implements InfoDao{

	private Info mappingInfo(ResultSet rs) throws SQLException {
		Info info = new Info();
		info.setId(rs.getInt("id"));
		info.setProperty(rs.getString("property"));
		info.setType(rs.getString("type"));
		info.setValue(rs.getString("value"));
		//info.setCard(rs.getBlob("img_front")); //需要用到card时在此添加
		return info;
		
	}
	
	public List<Info> getInfoesByCard(int cardId){
		
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		List listInfo = new ArrayList<Info>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			Info info;
			String sql = "select * from info where card = ?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cardId);
			rs = ps.executeQuery();
			while(rs.next()){
				info = mappingInfo(rs);
				listInfo.add(info);
			}
		} catch (SQLException e){
			throw new DaoException(e.getMessage(), e);
		}finally {
			dataSource.free(conn);
		}
		return listInfo;
		
	}

	public void addInfo(Info info) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into info(property,type,value,card) values(?,?,?,?);";
			ps = conn.prepareStatement(sql);
			ps.setString(1, info.getProperty());
			ps.setString(2, info.getType());
			ps.setString(3, info.getValue());
			ps.setInt(4, info.getCardId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("添加info信息失败", e);
		} finally {
			dataSource.free(conn);
		}
	}

	public void delete(int id) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "delete info where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("删除info信息失败", e);
		} finally {
			dataSource.free(conn);
		}
	}

	public Info getInfo(int id) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Info info = new Info();
		try {
			String sql = "select * from info  where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				info = mappingInfo(rs);
			}
		} catch (SQLException e){
			throw new DaoException(e.getMessage(), e);
		}finally {
			dataSource.free(conn);
		}
		return info;
	}

	public void update(Info info) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "update info  set property=?,type=?,value=? where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, info.getProperty());
			ps.setString(2, info.getType());
			ps.setString(3, info.getValue());
			ps.setInt(4, info.getId());
			ps.executeUpdate();
		} catch (SQLException e){
			throw new DaoException("更新info信息失败", e);
		}finally {
			dataSource.free(conn);
		}
	}

}
