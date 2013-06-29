package edu.sdkd.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.dao.DaoException;
import edu.sdkd.dao.UserDao;
import edu.sdkd.dao.impl.UserDaoImpl;
import edu.sdkd.domain.User;

public class UserDeleteServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(!((User)request.getSession().getAttribute("user")).isAdmin()){
			response.sendRedirect("");
			return;
		}
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!((User)request.getSession().getAttribute("user")).isAdmin()){
			response.sendRedirect("");
			return;
		}
		int id = Integer.valueOf(request.getParameter("uid"));
		UserDao userDao = new UserDaoImpl();
		
		try {
			
			
			userDao.deleteUser(id);
			response.sendRedirect("UserManagerServlet");
			
		} catch (DaoException e) {
			
			request.setAttribute("failed", "删除失败！");
			request.getRequestDispatcher("/UserManagerServlet")
					.forward(request, response);
			return;
		}

	}

}
