package edu.sdkd.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.bean.CardInfoBean;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Info;
import edu.sdkd.service.CardService;
import edu.sdkd.service.impl.CardServiceImpl;

public class CircleCardInfoesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("1");
		
		CardService cardService = new CardServiceImpl();
		int circleId = Integer.valueOf(request.getParameter("id"));
		System.out.println("2");
		Map<Card, CardInfoBean> cardInfoesMap = cardService.getAllCardPartInfoes(circleId);
		
		System.out.println("3");
		request.setAttribute("cardInfoesMap", cardInfoesMap);
		System.out.println("4");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		System.out.println("5");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
