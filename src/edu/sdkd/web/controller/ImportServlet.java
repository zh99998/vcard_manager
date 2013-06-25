package edu.sdkd.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.domain.Card;

public class ImportServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		CardDao cardDao = new CardDaoImpl();
		for(Card card:cardDao.list()){
			out.print(card.getInfoes().toString());
		}
		//out.print(cardDao.list().toString());
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
