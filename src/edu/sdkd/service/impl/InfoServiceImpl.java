package edu.sdkd.service.impl;

import java.util.List;

import edu.sdkd.dao.InfoDao;
import edu.sdkd.dao.impl.InfoDaoImpl;
import edu.sdkd.domain.Info;
import edu.sdkd.service.InfoService;

public class InfoServiceImpl implements InfoService {

	public List<Info> getInfoes(int cardId) {
		InfoDao infoDao = new InfoDaoImpl();
		return infoDao.getInfoesByCard(Integer.valueOf(cardId));
	}

}
