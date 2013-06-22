package edu.sdkd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import edu.sdkd.dao.DaoException;
import edu.sdkd.datasource.MyDataSource;
import edu.sdkd.domain.Card;

public class CardDaoImpl {
	public void addCard(Card card) {
		MyDataSource dataSource = new MyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into Card(createdAt,updatedAt,deleted,isMe,imgBack,imgFront)values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(System));
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			dataSource.free(conn);
		}
	}
}
