package edu.sdkd.web.controller;

import java.io.IOException;

import javax.activation.FileDataSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.InfoDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.dao.impl.InfoDaoImpl;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Info;
import edu.sdkd.service.CardService;
import edu.sdkd.service.impl.CardServiceImpl;

public class CardServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("delete").equals("delete")) {
			String deleted = request.getParameter("id");
			CardDao cardDao = new CardDaoImpl();
			cardDao.deleteCard(deleted);
		}
		response.sendRedirect("");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * System.out.println(request.getParameter("field"));
		 * System.out.println(request.getParameter("id"));
		 * System.out.println(request.getParameter("img"));
		 */
		CardService cardService = new CardServiceImpl();
		System.out.println(100);
		System.out.println(10);
		if (request.getParameter("action") != null && request.getParameter("action").equals("addcard")) {
			System.out.println(104);
			String cardName = request.getParameter("FN");
			Card card = new Card();
			Info info = new Info();
			CardDao cardDao = new CardDaoImpl();
			int id = cardDao.addCardAndGetId(card);
			info.setProperty("FN");
			info.setValue(cardName);
			info.setCardId(id);
			InfoDao infoDao = new InfoDaoImpl();
			infoDao.addInfo(info);
			response.sendRedirect("");
			
		} else {
			System.out.println(105);
			int id = Integer.valueOf(request.getParameter("id"));
			if (request.getParameter("_method") != null && request.getParameter("_method").equals("delete")) {
				if (request.getParameter("img").equals("imgBack")) {
					cardService.deleteImgBack(id);
				}
				if (request.getParameter("img").equals("imgFront")) {
					cardService.deleteImgFront(id);
				}
			} else {
				System.out.println(101);
				String field = request.getParameter("field");
				String img = request.getParameter("img");
				if (field.equals("imgFront")) {
					cardService.saveImgFront(id, img);
				} else if (field.equals("imgBack")) {
					cardService.saveImgBack(id, img);
				} else {
					System.out.println("保存图片失败");
				}
				System.out.println(102);
			}
		}
	}

}