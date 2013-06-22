package edu.sdkd.dao;

import java.util.List;

import edu.sdkd.domain.Card;

public interface CardDao {
	public void addCard(Card card);	
	public Card getCard(int id);
	public void update(Card card);
	public void delete(Card card);
	public List<Card> list();
}
