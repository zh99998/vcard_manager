package edu.sdkd.web.controller;

import java.io.IOException;

import javax.activation.FileDataSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.CircleCardDao;
import edu.sdkd.dao.InfoDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.dao.impl.CircleCardDaoImpl;
import edu.sdkd.dao.impl.InfoDaoImpl;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Info;
import edu.sdkd.service.CardService;
import edu.sdkd.service.impl.CardServiceImpl;

public class CardServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("uid")== null){
			response.sendRedirect("login");
			return;
		}
		
		if (request.getParameter("delete").equals("delete")) {
			String deleted = request.getParameter("id");
			if(deleted == null || deleted.equals("")){
				response.sendRedirect("");
				return;
			}
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
			String cardName = request.getParameter("N");
			Card card = new Card();
			Info info = new Info();
			CardDao cardDao = new CardDaoImpl();
			int id = cardDao.addCardAndGetId(card);
			info.setProperty("N");
			info.setValue(cardName);
			info.setCardId(id);
			InfoDao infoDao = new InfoDaoImpl();
			infoDao.addInfo(info);
			
			String circleId = request.getParameter("circleId");
			if(circleId !=null && !circleId.equals("")){
				CircleCardDao circleCardDao = new CircleCardDaoImpl();
				circleCardDao.addCard2Circle(id, Integer.valueOf(circleId));
			}
 			
			response.sendRedirect("cards?id="+id);
			
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
