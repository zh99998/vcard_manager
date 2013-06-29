package edu.sdkd.web.controller;

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

import net.sf.json.JSONObject;

import edu.sdkd.bean.CardInfoBean;
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
import edu.sdkd.service.CardService;
import edu.sdkd.service.impl.CardServiceImpl;
import edu.sdkd.utils.Utils;

public class ORGViewServlet extends HttpServlet {

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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("uid")== null){
			response.sendRedirect("login");
			return;
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
		
		CardDao cardDao = new CardDaoImpl();
		Map<String, Map<Card, CardInfoBean>> orgview = new HashMap<String, Map<Card, CardInfoBean>>();

		CardService cardService = new CardServiceImpl();
		Map<Card, CardInfoBean> map = cardService.getAllCardPartInfoes();
		for (Card card : map.keySet()) {
			for (Info info : card.getInfoes()) {
				if (info.getProperty().equals("ORG")) {
					if (orgview.get(info.getValue()) == null) {
						orgview.put(info.getValue(), new HashMap<Card, CardInfoBean>());
					}

					orgview.get(info.getValue()).put(card, map.get(card));
					break;
				}
			}
		}

		request.setAttribute("orgviewjson", Utils.JSON2Str(orgview));

		request.getRequestDispatcher("/orgview.jsp").forward(request, response);

	}

}
