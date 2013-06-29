package edu.sdkd.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.impl.CardDaoImpl;

public class MergeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardIds = request.getParameter("id");
		CardDao cardDao = new CardDaoImpl();
		cardDao.merge(cardIds);
		response.sendRedirect("");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
