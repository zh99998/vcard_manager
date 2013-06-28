package edu.sdkd.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.CircleCardDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.dao.impl.CircleCardDaoImpl;
import edu.sdkd.domain.Card;
import edu.sdkd.service.CircleService;

public class CircleServiceImpl implements CircleService {
	//根据circle的id得到所有的card
	public List<Card> getCards(int circleId) {
		System.out.println("9");
		CircleCardDao circleCardDao = new CircleCardDaoImpl();
		System.out.println("10");
		CardDao cardDao = new CardDaoImpl();
		System.out.println("14");
		List<Card> listCards = new ArrayList<Card>();
		System.out.println("13");
		List<Integer> listCardId = circleCardDao.getCardId(circleId);
		System.out.println("11");
		for(int cardId:listCardId){
			listCards.add(cardDao.getCard(cardId));
		}
		System.out.println("12");
		return listCards;
	}

}
