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

import edu.sdkd.dao.CircleCardDao;
import edu.sdkd.dao.DaoException;
import edu.sdkd.datasource.MyDataSource;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.CircleCard;

public class CircleCardDaoImpl implements CircleCardDao {

	public List<CircleCard> list() {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		List listCircleCard = new ArrayList<CircleCard>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			CircleCard circlecard=new CircleCard();
			String sql = "select * from circle_cards;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				circlecard = mappingCircleCard(rs);
				listCircleCard.add(circlecard);
				System.out.println(10);
			}
		} catch (SQLException e) {
			throw new DaoException("获取circlecard列表失败1", e);
		} finally {
			dataSource.free(conn);
		}
		return listCircleCard;
	}

	private CircleCard mappingCircleCard(ResultSet rs) throws SQLException {
		CircleCard circleCard = new CircleCard();
		circleCard.setCircleId(rs.getInt("circle"));
		circleCard.setCardId(rs.getInt("cards"));
		return circleCard;
	}

	public List<Integer> getCardId(int circleId) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		List<Integer> listCardId = new ArrayList<Integer>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select cards from circle_cards where circle=?;";
			ps = conn.prepareStatement(sql);
			System.out.println("18");
			ps.setInt(1, circleId);
			rs = ps.executeQuery();
			while (rs.next()) {
				int cardId = rs.getInt("cards");
				listCardId.add(cardId);
			}
			System.out.println("20");
		} catch (SQLException e) {
			throw new DaoException("获取circlecard列表失败2", e);
		} finally {
			dataSource.free(conn);
		}
		System.out.println("21");
		return listCardId;
	}

	public List<Integer> getCircleId(int cardId) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		List<Integer> listCardId = new ArrayList<Integer>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select circle from circle_cards where cards=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cardId);
			rs = ps.executeQuery();
			while (rs.next()) {
				int circleId = rs.getInt("circle");
				listCardId.add(circleId);
			}
		} catch (SQLException e) {
			throw new DaoException("获取circlecard列表失败2", e);
		} finally {
			dataSource.free(conn);
		}
		return listCardId;
	}

	//把一个card放到circle
	public void addCard2Circle(int cardId, int circleId) {
		MyDataSource dataSource = MyDataSource.getMyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			CircleCard circlecard=new CircleCard();
			String sql = "insert into circle_cards(circle,cards) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, circleId);
			ps.setInt(2, cardId);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("获取circlecard列表失败1", e);
		} finally {
			dataSource.free(conn);
		}
	}

}
