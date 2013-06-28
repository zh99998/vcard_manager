package edu.sdkd.dao;

import java.util.List;

import edu.sdkd.domain.CircleCard;

public interface CircleCardDao {
	// 得到所有的CircleCard
	public List<CircleCard> list();

	// 根据circle的id得到card的id
	public List<Integer> getCardId(int circleId);
	public List<Integer> getCircleId(int cardId);
	//把一个card放到一个circle里
	void addCard2Circle(int cardId,int circleId);
	//把一个card从一个circle删除
	
}
