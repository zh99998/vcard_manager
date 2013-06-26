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

	public void addInfo(Info info) {
		
	}

	public void delete(Info info) {
		// TODO Auto-generated method stub
		
	}

	public Info getInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Info info) {
		// TODO Auto-generated method stub
		
	}
	
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
	
}
