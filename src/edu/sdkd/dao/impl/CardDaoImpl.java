package edu.sdkd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.DaoException;
import edu.sdkd.datasource.MyDataSource;
import edu.sdkd.domain.Card;

public class CardDaoImpl implements CardDao{
	public void addCard(Card card) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into card(createdAt,updatedAt,deleted,isMe,imgBack,imgFront)values(?,?,?,?,?,?);";
			ps = conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(System.currentTimeMillis()));
			ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			ps.setBoolean(3, card.isDeleted());
			ps.setBoolean(4, card.isMe());
			ps.setBlob(5, card.getImgBack());
			ps.setBlob(6, card.getImgFront());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			dataSource.free(conn);
		}
	}
	
	public void delete(Card card) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from card  where id=" + card.getId()+";";
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e){
			throw new DaoException(e.getMessage(), e);
		}finally {
			dataSource.free(conn);
		}
	}

	public Card getCard(int id) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Card card = new Card();
		try {
			String sql = "select * from card  where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				card = mappingCard(rs);
			}
		} catch (SQLException e){
			throw new DaoException(e.getMessage(), e);
		}finally {
			dataSource.free(conn);
		}
		return card;
	}

	private Card mappingCard(ResultSet rs) throws SQLException {
		Card card = new Card();
		card.setId(rs.getInt("id"));
		card.setCreatedAt(rs.getDate("created_at"));
		card.setUpdatedAt(rs.getDate("updated_at"));
		card.setMe(rs.getBoolean("is_me"));
		card.setDeleted(rs.getBoolean("deleted"));
		card.setImgBack(rs.getBlob("img_back"));
		card.setImgFront(rs.getBlob("img_front"));
		return card;
		
	}

	public void update(Card card) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "update card  set deleted=?,img_back=?,img_front=?,is_me=? where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setBoolean(1, card.isDeleted());
			ps.setBlob(2, card.getImgBack());
			ps.setBlob(3, card.getImgFront());
			ps.setBoolean(4, card.isMe());
			int lineModified = ps.executeUpdate();
		} catch (SQLException e){
			throw new DaoException(e.getMessage(), e);
		}finally {
			dataSource.free(conn);
		}
	}
	
	public List<Card> list(){
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		List listCard = new ArrayList<Card>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			Card card;
			String sql = "select * from card;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				card = mappingCard(rs);
				listCard.add(card);
			}
		} catch (SQLException e){
			throw new DaoException(e.getMessage(), e);
		}finally {
			dataSource.free(conn);
		}
		return listCard;
	}
	
}
