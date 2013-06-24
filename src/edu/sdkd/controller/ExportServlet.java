package edu.sdkd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Info;

public class ExportServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/x-vcard");
		PrintWriter out = response.getWriter();

		CardDao cardDao = new CardDaoImpl();
		List<Card> cards = cardDao.list();
		for(Card card:cards){
			out.println("BEGIN:VCARD");
			out.println("VERSION:2.1");
			for(Info info:card.getInfoes()){
				out.println(info.getProperty()+";"+info.getType()+":"+info.getValue());
			}
			out.println("END:VCARD");
		}
		out.flush();
		out.close();
	}

}
