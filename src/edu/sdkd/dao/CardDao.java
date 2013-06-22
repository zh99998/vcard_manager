package edu.sdkd.dao;

import edu.sdkd.domain.Card;

public interface CardDao {
	public void addCard(Card card);	
	public Card getCard(int id);
	public void update(Card card);
	public void delete(Card card);
}
