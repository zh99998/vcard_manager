package edu.sdkd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.dao.CardDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Info;

public class ORGViewServlet extends HttpServlet {

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

		CardDao cardDao = new CardDaoImpl();
		Map<String, Set<Card>> orgview = new HashMap<String, Set<Card>>();
		for(Card card:cardDao.list()){
			//out.println(card);
			for(Info info:card.getInfoes()){
				//out.println(info.getProperty());
				if(info.getProperty().equals("ORG")){
					//out.println(info);
					if(orgview.get(info.getValue()) == null){
						orgview.put(info.getValue(), new HashSet());
					}
					orgview.get(info.getValue()).add(card);
					break;
				}
			}
		}
		
		request.setAttribute("orgview", orgview);
		
		request.getRequestDispatcher("/orgview.jsp").forward(request, response);
		
		
		//out.println(orgview);
		//out.flush();
		//out.close();
		
		

	}

}
