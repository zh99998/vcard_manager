package edu.sdkd.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.Before;

import edu.sdkd.bean.CardInfoBean;
import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.datasource.MyDataSource;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Info;
import edu.sdkd.domain.User;
import edu.sdkd.service.CardService;
import edu.sdkd.service.UserService;
import edu.sdkd.service.impl.CardServiceImpl;
import edu.sdkd.service.impl.UserServiceImpl;
import edu.sdkd.utils.Utils;

public class Test {
	@org.junit.Test
	public void testConnection() throws SQLException{
		CardDao cardDao = new CardDaoImpl();
		System.out.print(cardDao.list());
	}
	
	@org.junit.Test
	public void testGetTime(){
		System.out.println(Utils.getCurrentTime());
	}
	
	@org.junit.Test
	public void testReadFile(){
		Properties properties=null;
		properties = Utils.readProperties("db.properties");
		System.out.println(properties.getProperty("driver"));
		System.out.println(properties.getProperty("url"));
		System.out.println(properties.getProperty("user"));
		System.out.println(properties.getProperty("password"));
	}
	
	@org.junit.Test
	public void testMap(){
		String a="zhang";
		String b="zhang";
		Map<String,String> map = new HashMap<String, String>();
		map.put(a, "30");
		System.out.println(map.get(b));
		System.out.println(map.get("zhang"));
	}
	
	@org.junit.Test
	public void testLogin(){
		UserService loginService = new UserServiceImpl();
		User user = loginService.login("xiao", "456");
		if(user!=null){
			System.out.println(user.getId());
		}else {
			System.out.println("login failed");
		}
	}
	
	@org.junit.Test
	public void testJson2Str(){
		CardDao cardDao = new CardDaoImpl();
		Map<String, Map<Card, CardInfoBean>> orgview = new HashMap<String, Map<Card, CardInfoBean>>();

		CardService cardService = new CardServiceImpl();
		Map<Card, CardInfoBean> map = cardService.getAllCardPartInfoes();
		for (Card card : map.keySet()) {
			for (Info info : card.getInfoes()) {
				if (info.getProperty().equals("ORG")) {
					if (orgview.get(info.getValue()) == null) {
						orgview.put(info.getValue(), new HashMap<Card, CardInfoBean>());
					}

					orgview.get(info.getValue()).put(card, map.get(card));
					break;
				}
			}
		}

		System.out.println(Utils.JSON2Str(orgview));
	}
}
