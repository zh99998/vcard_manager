package edu.sdkd.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.bean.CardInfoBean;
import edu.sdkd.dao.CircleCardDao;
import edu.sdkd.dao.CircleDao;
import edu.sdkd.dao.impl.CircleCardDaoImpl;
import edu.sdkd.dao.impl.CircleDaoImpl;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Circle;
import edu.sdkd.domain.CircleCard;
import edu.sdkd.domain.Info;
import edu.sdkd.service.CardService;
import edu.sdkd.service.impl.CardServiceImpl;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		CardService cardService = new CardServiceImpl();
		Map<Card, CardInfoBean> cardInfoesMap = cardService.search(request.getParameter("key"));
		
		request.setAttribute("cardInfoesMap", cardInfoesMap);
		
		
		CircleDao circleDao = new CircleDaoImpl();
		List<Circle> circles = circleDao.list();
		request.setAttribute("circles", circles);
		
		CircleCardDao circcardleDao = new CircleCardDaoImpl();
		Map<Integer, Integer> circlecards = new HashMap<Integer, Integer>();
		for(CircleCard circlecard:circcardleDao.list()){
			if(circlecards.get(circlecard.getCircleId()) == null){
				circlecards.put(circlecard.getCircleId(), 0);
			}
			circlecards.put(circlecard.getCircleId(), circlecards.get(circlecard.getCircleId())+1);
		}
		request.setAttribute("num", circlecards);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
