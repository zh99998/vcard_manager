package edu.sdkd.web.controller;

import java.io.IOException;

import javax.activation.FileDataSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.service.CardService;
import edu.sdkd.service.impl.CardServiceImpl;

public class CardServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		

		/*
		 * System.out.println(request.getParameter("field"));
		 * System.out.println(request.getParameter("id"));
		 * System.out.println(request.getParameter("img"));
		 */
		CardService cardService = new CardServiceImpl();

		if (request.getParameter("_method") != null && request.getParameter("_method").equals("delete")) {
			if (request.getParameter("img").equals("imgBack")) {
				cardService.deleteImgBack(id);
			}
			if (request.getParameter("img").equals("imgFront")) {
				cardService.deleteImgFront(id);
			}
		} else {
			System.out.println("shangchuanzhengmian1");
			String field = request.getParameter("field");
			String img = request.getParameter("img");
			System.out.println("shangchuanzhengmian2");
			if (field.equals("imgFront")) {
				System.out.println("shangchuanzhengmian3");
				cardService.saveImgFront(id, img);
			} else if (field.equals("imgBack")) {
				System.out.println("shangchuanzhengmian4");
				cardService.saveImgBack(id, img);
			} else {
				System.out.println("保存图片失败");
			}
			System.out.println("shangchuanzhengmian5");
		}
	}

}
