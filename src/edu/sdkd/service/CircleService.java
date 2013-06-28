package edu.sdkd.service;

import java.util.List;

import edu.sdkd.domain.Card;

public interface CircleService {
	//根据circle的id得到所有的card
	List<Card> getCards(int circle_id);
}
