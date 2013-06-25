package edu.sdkd.service;

import java.util.List;
import java.util.Map;

import edu.sdkd.bean.CardInfoBean;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Info;

public interface CardService {

	//得到所有名片的信息
	public abstract Map<Card, CardInfoBean> getCardInfoes();
}