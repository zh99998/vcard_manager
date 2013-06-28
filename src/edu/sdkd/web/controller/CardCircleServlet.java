package edu.sdkd.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.dao.CircleCardDao;
import edu.sdkd.dao.impl.CircleCardDaoImpl;

public class CardCircleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean checked = Boolean.valueOf(request.getParameter("checked"));
		int cardId = Integer.valueOf(request.getParameter("card_id"));
		int circleId = Integer.valueOf(request.getParameter("circle_id"));
		
		CircleCardDao circleCardDao = new CircleCardDaoImpl();
		
		if(checked){
			circleCardDao.addCard2Circle(cardId, circleId);
			response.sendRedirect("");
		}
		if (!checked) {
			circleCardDao.deleteCard4Circle(cardId, circleId);
			response.sendRedirect("");
		}
	}

}
