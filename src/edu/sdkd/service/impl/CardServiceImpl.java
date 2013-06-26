package edu.sdkd.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import edu.sdkd.bean.CardInfoBean;
import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.InfoDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.dao.impl.InfoDaoImpl;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Info;
import edu.sdkd.service.CardService;

public class CardServiceImpl implements CardService {
//	public Map<Card, CardInfoBean> cardInfoesMap = new HashMap<Card, CardInfoBean>();
	public Map<Card, CardInfoBean> cardInfoesMap = new LinkedHashMap<Card, CardInfoBean>();
	/* (non-Javadoc)
	 * @see edu.sdkd.service.impl.CardService#getCardInfoes()
	 */
	
	//得到所有名片的FK,TEL,EMAIL,ORG的信息
	public Map<Card, CardInfoBean> getAllCardPartInfoes(){
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
