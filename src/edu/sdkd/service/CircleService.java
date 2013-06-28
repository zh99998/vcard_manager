package edu.sdkd.service;

import java.util.List;

import edu.sdkd.domain.Card;
import edu.sdkd.domain.Circle;

public interface CircleService {
	//根据circle的id得到所有的card
	List<Card> getCards(int circle_id);
	//根据card的id得到所有的circle
	List<Circle> getCircle(int card_id);
}
