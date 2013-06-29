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

public class AddUserServlet extends HttpServlet {

	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           doPost(request,response);
           
           
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		UserDao userDao = new UserDaoImpl();
		try{
		userDao.addUser(username,password);
		}catch(DaoException e){
			request.setAttribute("failed", "用户名重复！");
			request.getRequestDispatcher("/servlet/UserManagerServlet").forward(request,
					response);
			return;
		}
		response.sendRedirect("UserManagerServlet");
		
	}

	

}
