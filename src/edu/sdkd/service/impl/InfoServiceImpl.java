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

	public void deleteInfo(int id) {
		InfoDao infoDao = new InfoDaoImpl();
		infoDao.delete(id);
	}

	public void updateInfo(int id, String value) {
		InfoDao infoDao = new InfoDaoImpl();
		infoDao.update(id, value);
	}

	public void addInfo(Info info) {
		InfoDao infoDao = new InfoDaoImpl();
		infoDao.addInfo(info);
	}

	public void addInfo(String property, String value, int cardId) {
		InfoDao infoDao = new InfoDaoImpl();
		infoDao.addInfo(property,value,cardId);
	}

}
