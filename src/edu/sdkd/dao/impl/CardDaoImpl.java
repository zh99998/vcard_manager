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
import java.util.Map;

import edu.sdkd.bean.CardInfoBean;
import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.DaoException;
import edu.sdkd.datasource.MyDataSource;
import edu.sdkd.domain.Card;

public class CardDaoImpl implements CardDao {
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
			ps.setString(5, card.getImgBack());
			ps.setString(6, card.getImgFront());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("添加card信息失败", e);
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
			String sql = "delete from card  where id=" + card.getId() + ";";
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DaoException("删除card信息失败", e);
		} finally {
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
			conn = dataSource.getConnection();
			String sql = "select * from card  where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				card = mappingCard(rs);
			}
		} catch (SQLException e) {
			throw new DaoException("获取card信息失败", e);
		} finally {
			dataSource.free(conn);
		}
		System.out.println(card.toString());
		return card;
	}

	private Card mappingCard(ResultSet rs) throws SQLException {
		Card card = new Card();
		card.setId(rs.getInt("id"));
		card.setCreatedAt(rs.getDate("created_at"));
		card.setUpdatedAt(rs.getDate("updated_at"));
		card.setMe(rs.getBoolean("is_me"));
		card.setDeleted(rs.getBoolean("deleted"));
		card.setImgBack(rs.getString("img_back"));
		card.setImgFront(rs.getString("img_front"));
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
			ps.setString(2, card.getImgBack());
			ps.setString(3, card.getImgFront());
			ps.setBoolean(4, card.isMe());
			int lineModified = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("更新card信息失败", e);
		} finally {
			dataSource.free(conn);
		}
	}

	public List<Card> list() {
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
			while (rs.next()) {
				card = mappingCard(rs);
				listCard.add(card);
			}
		} catch (SQLException e) {
			throw new DaoException("获取card列表失败", e);
		} finally {
			dataSource.free(conn);
		}
		return listCard;
	}

	// 保存上传的背面图
	public void saveImgBack(int id, String imgFront) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "update card  set img_back=? where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, imgFront);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("上传背面图失败", e);
		} finally {
			dataSource.free(conn);
		}
	}

	// 保存上传的正面图
	public void saveImgFront(int id, String imgBack) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "update card  set img_front=? where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, imgBack);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("上传正面图失败", e);
		} finally {
			dataSource.free(conn);
		}
	}

	// 删除背面图
	public void deleteImgBack(int id) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "update card set img_back=null where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("删除背面图失败", e);
		} finally {
			dataSource.free(conn);
		}
	}

	// 删除正面图
	public void deleteImgFront(int id) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "update card set img_front=null where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("删除正面图失败", e);
		} finally {
			dataSource.free(conn);
		}
	}

	public void deleteCard(String cardId) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from card  where id in(" + cardId + ");";
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DaoException("删除card信息失败", e);
		} finally {
			dataSource.free(conn);
		}
	}

	public int addCardAndGetId(Card card) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into card() values();";
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate(sql, ps.RETURN_GENERATED_KEYS);
			rs = ps.getGeneratedKeys();
			if(rs.next()){
				
				System.out.println(rs.getInt(1));
				
			}
			return rs.getInt(1);	
		} catch (SQLException e) {
			throw new DaoException("添加card信息失败", e);
		} finally {
			dataSource.free(conn);
		}
	}

	public List<Card> search(String key) {
		
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		List listCard = new ArrayList<Card>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			Card card;
			String sql = "select * from card where id in (select card from info where instr(value, ?));";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, key);
			System.out.println(ps);
			System.out.println(ps);
			rs = ps.executeQuery();
			while (rs.next()) {
				card = mappingCard(rs);
				listCard.add(card);
			}
		} catch (SQLException e) {
			throw new DaoException("获取card列表失败", e);
		} finally {
			dataSource.free(conn);
		}
		return listCard;
	}

	public void merge(String ids) {
		String[] idsarray = ids.split(",");
		String main = idsarray[0];
		
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		List listCard = new ArrayList<Card>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			Card card;
			String sql = "update info set card="+main+" where card in("+ids+")";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			
			sql = "delete from card where id in("+ids+") and id!="+main ;
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new DaoException("获取card列表失败", e);
		} finally {
			dataSource.free(conn);
		}
	}

	public List<Card> list(String ids) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		List listCard = new ArrayList<Card>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			Card card;
			String sql = "select * from card where id in("+ids+");";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				card = mappingCard(rs);
				listCard.add(card);
			}
		} catch (SQLException e) {
			throw new DaoException("获取card列表失败", e);
		} finally {
			dataSource.free(conn);
		}
		return listCard;
	}
	
}
