package edu.sdkd.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.sdkd.bean.CardInfoBean;
import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.CircleDao;
import edu.sdkd.dao.InfoDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.dao.impl.CircleDaoImpl;
import edu.sdkd.dao.impl.InfoDaoImpl;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Info;
import edu.sdkd.service.CardService;
import edu.sdkd.service.CircleService;

public class CardServiceImpl implements CardService {
	// public Map<Card, CardInfoBean> cardInfoesMap = new HashMap<Card,
	// CardInfoBean>();
	public Map<Card, CardInfoBean> cardInfoesMap = new LinkedHashMap<Card, CardInfoBean>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.sdkd.service.impl.CardService#getCardInfoes()
	 */

	// 得到所有名片的FK,TEL,EMAIL,ORG的信息
	public Map<Card, CardInfoBean> getAllCardPartInfoes() {
		CardDao cardDao = new CardDaoImpl();
		List<Card> cardList = cardDao.list();
		if (cardList == null)
			return null;
		for (Card card : cardList) {
			CardInfoBean cardInfoBean = new CardInfoBean();
			for (Info info : card.getInfoes()) {
				if (info.getProperty().equals("N")) {
					cardInfoBean.setFN(info.getValue());
				}
				if (info.getProperty().equals("TEL")) {
					cardInfoBean.setTEL(info.getValue());
				}
				if (info.getProperty().equals("EMAIL")) {
					cardInfoBean.setEMAIL(info.getValue());
				}
				if (info.getProperty().equals("ORG")) {
					cardInfoBean.setORG(info.getValue());
				}
			}
			cardInfoesMap.put(card, cardInfoBean);
		}
		return cardInfoesMap;
	}

	public Map<Card, CardInfoBean> getAllCardPartInfoes(int circle) {
		CircleService circleService = new CircleServiceImpl();
		System.out.println("5");
		List<Card> cardList = circleService.getCards(circle);
		System.out.println("6");
		for (Card card : cardList) {
			CardInfoBean cardInfoBean = new CardInfoBean();
			for (Info info : card.getInfoes()) {
				if (info.getProperty().equals("N")) {
					cardInfoBean.setFN(info.getValue());
				}
				if (info.getProperty().equals("TEL")) {
					cardInfoBean.setTEL(info.getValue());
				}
				if (info.getProperty().equals("EMAIL")) {
					cardInfoBean.setEMAIL(info.getValue());
				}
				if (info.getProperty().equals("ORG")) {
					cardInfoBean.setORG(info.getValue());
				}
			}
			cardInfoesMap.put(card, cardInfoBean);
		}
		System.out.println("7");
		return cardInfoesMap;
	}

	public void saveImgBack(int id, String imgBack) {
		CardDao cardDao = new CardDaoImpl();
		cardDao.saveImgBack(id, imgBack);
	}

	public void saveImgFront(int id, String imgFront) {
		CardDao cardDao = new CardDaoImpl();
		cardDao.saveImgFront(id, imgFront);
	}

	public void deleteImgBack(int id) {
		CardDao cardDao = new CardDaoImpl();
		cardDao.deleteImgBack(id);
	}

	public void deleteImgFront(int id) {
		CardDao cardDao = new CardDaoImpl();
		cardDao.deleteImgFront(id);
	}

	public Map<Card, CardInfoBean> search(String key) {

		CardDao cardDao = new CardDaoImpl();
		List<Card> cardList = cardDao.search(key);
		if (cardList == null)
			return null;
		for (Card card : cardList) {
			CardInfoBean cardInfoBean = new CardInfoBean();
			for (Info info : card.getInfoes()) {
				if (info.getProperty().equals("N")) {
					cardInfoBean.setFN(info.getValue());
				}
				if (info.getProperty().equals("TEL")) {
					cardInfoBean.setTEL(info.getValue());
				}
				if (info.getProperty().equals("EMAIL")) {
					cardInfoBean.setEMAIL(info.getValue());
				}
				if (info.getProperty().equals("ORG")) {
					cardInfoBean.setORG(info.getValue());
				}
			}
			cardInfoesMap.put(card, cardInfoBean);
		}
		return cardInfoesMap;
	}
}
