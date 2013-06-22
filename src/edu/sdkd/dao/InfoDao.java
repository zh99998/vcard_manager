package edu.sdkd.dao;

import edu.sdkd.domain.Info;
public interface InfoDao {
	public void addInfo(Info info);	
	public Info getInfo(int id);	
	public void update(Info info);
	public void delete(Info info);
}
