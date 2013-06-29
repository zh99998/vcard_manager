package edu.sdkd.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.CircleCardDao;
import edu.sdkd.dao.CircleDao;
import edu.sdkd.dao.InfoDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.dao.impl.CircleCardDaoImpl;
import edu.sdkd.dao.impl.CircleDaoImpl;
import edu.sdkd.dao.impl.InfoDaoImpl;
import edu.sdkd.domain.Circle;
import edu.sdkd.domain.Info;
import edu.sdkd.service.CardService;
import edu.sdkd.service.CircleService;
import edu.sdkd.service.InfoService;
import edu.sdkd.service.impl.CircleServiceImpl;
import edu.sdkd.service.impl.InfoServiceImpl;

public class SelectInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cardId = Integer.valueOf(request.getParameter("id"));
		System.out.println(1);
		InfoService infoService = new InfoServiceImpl();
		System.out.println(2);
		List<Info> infoesList = infoService.getInfoes(cardId);
		System.out.println(3);
		CardDao cardDao = new CardDaoImpl();
		
		CircleDao circleDao = new CircleDaoImpl();
		List<Circle> circles = circleDao.list();
		request.setAttribute("circles", circles);
		
		request.setAttribute("infoesList", infoesList);
		System.out.println(4);
		request.setAttribute("card", cardDao.getCard(cardId));
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("BEGIN:VCARD");
		stringBuilder.append("VERSION:2.1");
		for (Info info : cardDao.getCard(cardId).getInfoes()) {
			String line = info.getProperty();
			if (info.getType() != null)
				line += ";" + info.getType();
			line += ":" + info.getValue();
			stringBuilder.append(line);
		}
		stringBuilder.append("END:VCARD");
		request.setAttribute("vcard", stringBuilder.toString());
		
		System.out.println(5);
		//CircleService circleService = new CircleServiceImpl();
		//List<Circle> currentCircles = circleService.getCircle(cardId);
		CircleCardDao circleCardDao = new CircleCardDaoImpl();
		List<Integer> circleIntegers = circleCardDao.getCircleId(cardId);
		
		System.out.println(circleIntegers);
		Map<Circle, Boolean> circleMap = new HashMap<Circle, Boolean>();
		for(Circle circle:circles){
			circleMap.put(circle, (circleIntegers.contains(circle.getId())));
		}
		request.setAttribute("circleMap", circleMap);
		request.getRequestDispatcher("/info.jsp").forward(request, response);
		System.out.println(6);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
