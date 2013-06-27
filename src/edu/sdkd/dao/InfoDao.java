package edu.sdkd.dao;

import java.util.List;

import edu.sdkd.domain.Info;
public interface InfoDao {
	public void addInfo(Info info);	
	public Info getInfo(int id);
	public void update(Info info);
	public void delete(int id);
	public List<Info> getInfoesByCard(int cardId);
}
