package edu.sdkd.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdkd.domain.User;
import edu.sdkd.service.UserService;
import edu.sdkd.service.impl.UserServiceImpl;

//处理表单提交请求
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * String username = request.getParameter("username");
		 * 
		 * try { Thread.sleep(1000*3); } catch (InterruptedException e) { //
		 * TODO Auto-generated catch blo e.printStackTrace(); }
		 * 
		 * System.out.println("---向数据库中注册用户---");
		 */
		
		//PrintWriter out = response.getWriter();
		
		// 对表单提交的字段进行合法性校验
		//request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		System.out.println(request.getParameter("captcha"));
		System.out.println(request.getSession().getAttribute("captcha"));
		if(request.getParameter("captcha") != null && Integer.valueOf(request.getParameter("captcha")) == request.getSession().getAttribute("captcha")){
			
			UserService userService = new UserServiceImpl();
			User user = userService.login(name, password);
			if (user != null) {
				int uid = user.getId();
				request.getSession().setAttribute("uid", uid);// 保存登录用户ID
				request.getSession().setAttribute("user", user);// 保存登录用户ID
				System.out.println("-----");
				System.out.println(uid);
				// out.print("登录成功");
				response.sendRedirect("");
				//
				//request.getRequestDispatcher("/servlet/CardInfoesServlet").forward(request, response);
			} else {
				// fail
				request.setAttribute("failed", "用户名或密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}

			boolean b = isTokenValid(request);
			if (!b) {
				System.out.println("请不要重复提交");
				return;
			}

			request.getSession().removeAttribute("token");
			System.out.println("--处理表单提交--");
		}else {
			request.setAttribute("failed", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	// 判断表单号是否有效
	private boolean isTokenValid(HttpServletRequest request) {

		String client_token = request.getParameter("token");
		if (client_token == null) {
			return false;
		}

		String server_token = (String) request.getSession().getAttribute("token");
		if (server_token == null) {
			return false;
		}
		if (!client_token.equals(server_token)) {
			return false;
		}

		return true;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}