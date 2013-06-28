package edu.sdkd.dao;

import java.util.List;

import edu.sdkd.domain.CircleCard;

public interface CircleCardDao {
	// 得到所有的CircleCard
	public List<CircleCard> list();

	// 根据circle的id得到card的id
	public List<Integer> getCardId(int circleId);
}
