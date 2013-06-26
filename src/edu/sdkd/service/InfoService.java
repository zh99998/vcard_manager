package edu.sdkd.service;

import java.util.List;

import edu.sdkd.domain.Info;

public interface InfoService {
	//得到某名片的全部信息
	public abstract List<Info> getInfoes(int cardId);
}
