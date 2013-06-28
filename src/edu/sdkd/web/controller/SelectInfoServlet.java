package edu.sdkd.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.InfoDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.dao.impl.InfoDaoImpl;
import edu.sdkd.domain.Info;
import edu.sdkd.service.CardService;
import edu.sdkd.service.InfoService;
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
		request.setAttribute("infoesList", infoesList);
		System.out.println(4);
		request.setAttribute("card", cardDao.getCard(cardId));
		System.out.println(5);
		request.getRequestDispatcher("/info.jsp").forward(request, response);
		System.out.println(6);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
