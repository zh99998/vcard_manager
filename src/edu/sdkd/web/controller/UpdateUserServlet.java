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

public class UpdateUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!((User) request.getSession().getAttribute("user")).isAdmin()) {
			response.sendRedirect("");
			return;
		}
		int id = Integer.valueOf(request.getParameter("uid"));
		request.setAttribute("userId", id);
		request.getRequestDispatcher("/userupdate.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(54);
		if (!((User) request.getSession().getAttribute("user")).isAdmin()) {
			response.sendRedirect("");
			return;
		}
		int id = Integer.valueOf(request.getParameter("userId"));
		String name = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		UserDao userDao = new UserDaoImpl();
		try {
			userDao.updateUser(name, password, id);
			response.sendRedirect("UserManagerServlet");
		} catch (DaoException e) {
			request.setAttribute("failed", "用户名重复！");
			request.getRequestDispatcher("/UserManagerServlet").forward(request, response);
		}

	}

}
