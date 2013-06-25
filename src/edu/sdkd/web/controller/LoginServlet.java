package edu.sdkd.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//处理表单提交请求
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*String username = request.getParameter("username");
		
		try {
			Thread.sleep(1000*3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch blo
			e.printStackTrace();
		}
		
		System.out.println("---向数据库中注册用户---");*/
		//对表单提交的字段进行合法性校验
		
		boolean b = isTokenValid(request);
		if(!b){ 
			System.out.println("请不要重复提交");
			return;
		}
		
		request.getSession().removeAttribute("token");
		System.out.println("--处理表单提交--");
		
	}

	//判断表单号是否有效
	private boolean isTokenValid(HttpServletRequest request) {
		
		String client_token = request.getParameter("token");
		if(client_token==null){
			return false;
		}
		
		String server_token = (String) request.getSession().getAttribute("token");
		if(server_token==null){
			return false;
		}
		if(!client_token.equals(server_token)){
			return false;
		}
		
		return true;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}