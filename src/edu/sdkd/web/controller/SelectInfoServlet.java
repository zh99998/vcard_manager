package edu.sdkd.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.dao.InfoDao;
import edu.sdkd.dao.impl.InfoDaoImpl;
import edu.sdkd.domain.Info;
import edu.sdkd.service.CardService;
import edu.sdkd.service.InfoService;
import edu.sdkd.service.impl.InfoServiceImpl;

public class SelectInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardId = request.getParameter("id");
		
		InfoService infoService = new InfoServiceImpl();
		List<Info> infoesList = infoService.getInfoes(Integer.valueOf(cardId));
		request.setAttribute("infoesList", infoesList);
		request.getRequestDispatcher("/info.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
