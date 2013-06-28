package edu.sdkd.service;

import java.util.List;

import edu.sdkd.domain.Info;

public interface InfoService {
	//得到某名片的全部信息
	public abstract List<Info> getInfoes(int cardId);
	//根据id删除一条info
	void deleteInfo(int id);
	//根据id和value更新一条info
	void updateInfo(int id,String value);
	//添加一条info
	void addInfo(Info info);
	//根据property,value,cardId添加一条info
	void addInfo(String property,String value,int cardId);
}
