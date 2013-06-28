package edu.sdkd.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.service.InfoService;
import edu.sdkd.service.impl.InfoServiceImpl;

public class InfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println(request.getParameter("id"));
		// System.out.println(request.getParameter("value"));
		PrintWriter out = response.getWriter();
		if (request.getParameter("id").substring(0,7).equals("create_")) {
			String property = request.getParameter("id").substring(7);
			String value = request.getParameter("value");
			String cardId = request.getParameter("card_id");
			/*System.out.println(property);
			System.out.println(value);
			System.out.println(cardId);*/
			InfoService infoService = new InfoServiceImpl();
			infoService.addInfo(property, value, Integer.valueOf(cardId));
			out.print(value);
		} else {

			int id = Integer.valueOf(request.getParameter("id").substring(8));
			String value = request.getParameter("value");
			InfoService infoService = new InfoServiceImpl();
			infoService.updateInfo(id, value);
			out.print(value);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("_method") != null && request.getParameter("_method").equals("delete")) {
			doDelete(request, response);
		} else {
			doGet(request, response);
		}
	}

	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println(request.getParameterMap());
		// System.out.println(request.getParameter("id"));
		InfoService infoService = new InfoServiceImpl();
		infoService.deleteInfo(Integer.valueOf(request.getParameter("id")));
	}

}
