package edu.sdkd.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.dao.UserDao;
import edu.sdkd.dao.impl.UserDaoImpl;
import edu.sdkd.domain.User;

public class UserManagerServlet extends HttpServlet {
         //显示用户数据的Servlet
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(!((User)request.getSession().getAttribute("user")).isAdmin()){
			response.sendRedirect("");
			return;
		}
		
		
		UserDao userDao = new UserDaoImpl();
		
		ArrayList<User> list = userDao.showUserList();
		        request.setAttribute("list", list);
	            request.getRequestDispatcher("/userlist.jsp").forward(request,
		                    response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	
}
