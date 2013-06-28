package edu.sdkd.service;

import java.util.List;
import java.util.Map;

import edu.sdkd.bean.CardInfoBean;
import edu.sdkd.dao.InfoDao;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Info;

public interface CardService {

	//得到所有名片的FK,TEL,EMAIL,ORG的信息
	public abstract Map<Card, CardInfoBean> getAllCardPartInfoes();
	public abstract Map<Card, CardInfoBean> getAllCardPartInfoes(int circle);
	//保存上传的正面图片
	void saveImgFront(int id,String imgFront);
	//保存上传的背面图片
	void saveImgBack(int id,String imgBack);
	//删除正面图片
	void deleteImgFront(int id);
	//删除背面图片
	void deleteImgBack(int id);
}
