package edu.sdkd.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.CircleCardDao;
import edu.sdkd.dao.CircleDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.dao.impl.CircleCardDaoImpl;
import edu.sdkd.dao.impl.CircleDaoImpl;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Circle;
import edu.sdkd.service.CircleService;

public class CircleServiceImpl implements CircleService {
	//根据circle的id得到所有的card
	public List<Card> getCards(int circleId) {
		CircleCardDao circleCardDao = new CircleCardDaoImpl();
		CardDao cardDao = new CardDaoImpl();
		List<Card> listCards = new ArrayList<Card>();
		List<Integer> listCardId = circleCardDao.getCardId(circleId);
		for(int cardId:listCardId){
			listCards.add(cardDao.getCard(cardId));
		}
		return listCards;
	}

	public List<Circle> getCircle(int cardId) {
		CircleCardDao circleCardDao = new CircleCardDaoImpl();
		CircleDao circleDao = new CircleDaoImpl();
		List<Circle> listCircle = new ArrayList<Circle>();
		List<Integer> listCircleId = circleCardDao.getCircleId(cardId);
		for(int circleId:listCircleId){
			listCircle.add(circleDao.getCircle(circleId));
		}
		return listCircle;
	}

}
