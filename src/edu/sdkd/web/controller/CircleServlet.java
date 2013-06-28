package edu.sdkd.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import edu.sdkd.dao.CircleCardDao;
import edu.sdkd.dao.CircleDao;
import edu.sdkd.dao.impl.CardDaoImpl;
import edu.sdkd.dao.impl.CircleCardDaoImpl;
import edu.sdkd.dao.impl.CircleDaoImpl;
import edu.sdkd.domain.Card;
import edu.sdkd.domain.Circle;
import edu.sdkd.domain.CircleCard;
import edu.sdkd.domain.Info;

public class CircleServlet extends HttpServlet {

	private Object list;

	/**
	 * The doDelete method of the servlet. <br>
	 * 
	 * This method is called when a HTTP delete request is received.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CircleDao circleDao = new CircleDaoImpl();
		Circle circle = circleDao.getCircle(Integer.valueOf(request.getParameter("id")));
       
		circleDao.delete(circle);
		response.sendRedirect("");
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("_method") != null) {
			if (request.getParameter("_method").equals("put")) {
				doPut(request, response);
				return;
			}else if (request.getParameter("_method").equals("delete")) {
				doDelete(request, response);
				return;
			}
		}
		CircleDao circleDao = new CircleDaoImpl();
		List<Circle> circles = circleDao.list();
		request.setAttribute("circles", circles);
		
		CircleCardDao circcardleDao = new CircleCardDaoImpl();
		Map<Integer, Integer> circlecards = new HashMap<Integer, Integer>();
		for(CircleCard circlecard:circcardleDao.list()){
			if(circlecards.get(circlecard.getCircleId()) == null){
				circlecards.put(circlecard.getCircleId(), 0);
			}
			circlecards.put(circlecard.getCircleId(), circlecards.get(circlecard.getCircleId())+1);
		}
		request.setAttribute("num", circlecards);
		
		request.getRequestDispatcher("/circles.jsp").forward(request, response);
		// out.flush();
		// out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("_method") != null) {
			if (request.getParameter("_method").equals("put")) {
				doPut(request, response);
				return;
			}else if (request.getParameter("_method").equals("delete")) {
				doDelete(request, response);
				return;
			}
		}

		Circle circle = new Circle();
		circle.setName(request.getParameter("name"));
		CircleDao circleDao = new CircleDaoImpl();
		circleDao.addCircle(circle);

		response.sendRedirect("");

	}

	/**
	 * The doPut method of the servlet. <br>
	 * 
	 * This method is called when a HTTP put request is received.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();



		CircleDao circleDao = new CircleDaoImpl();
		Circle circle = circleDao.getCircle(Integer.valueOf(request.getParameter("id")));

		circle.setName(request.getParameter("name"));
       
		circleDao.update(circle);
		response.sendRedirect("");
	
		//out.println(request.getParameter("name"));
		//out.println(circle.getId());
		//out.flush();
		//out.close();
	}

}

