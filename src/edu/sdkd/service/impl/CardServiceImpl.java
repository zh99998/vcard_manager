package edu.sdkd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import edu.sdkd.bean.CardInfoBean;
import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Info;
import edu.sdkd.service.CardService;

public class CardServiceImpl implements CardService {
	public Map<Card, CardInfoBean> cardInfoesMap = new HashMap<Card, CardInfoBean>();
	/* (non-Javadoc)
	 * @see edu.sdkd.service.impl.CardService#getCardInfoes()
	 */
	public Map<Card, CardInfoBean> getCardInfoes(){
		CardDao cardDao = new CardDaoImpl();
		List<Card> cardList = cardDao.list();
		if(cardList == null)
			return null;
		for (Card card : cardList) {
			CardInfoBean cardInfoBean = new CardInfoBean();
			for(Info info:card.getInfoes()){
				if(info.getProperty().equals("FN")){
					cardInfoBean.setFN(info.getValue());
				}
				if(info.getProperty().equals("TEL")){
					cardInfoBean.setTEL(info.getValue());
				}
				if(info.getProperty().equals("EMAIL")){
					cardInfoBean.setEMAIL(info.getValue());
				}
				if(info.getProperty().equals("ORG")){
					cardInfoBean.setORG(info.getValue());
				}
			}
			cardInfoesMap.put(card, cardInfoBean);
		}
		return cardInfoesMap;
	}
	
}
