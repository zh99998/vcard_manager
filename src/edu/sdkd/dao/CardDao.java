package edu.sdkd.dao;

import java.util.List;

import edu.sdkd.domain.Card;

public interface CardDao {
	public void addCard(Card card);	
	public Card getCard(int id);
	public void update(Card card);
	public void delete(Card card);
	public List<Card> list();
	//保存上传的正面图
	void saveImgFront(int id,String imgFront);
	//保存上传的背面图
	void saveImgBack(int id,String imgBack);
	//删除正面图
	void deleteImgFront(int id);
	//删除背面图
	void deleteImgBack(int id);
}
