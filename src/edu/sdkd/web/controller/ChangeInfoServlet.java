package edu.sdkd.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeInfoServlet extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = (Integer) request.getSession().getAttribute("uid");
		request.setCharacterEncoding("utf-8");
        //PrintWriter out = response.getWriter();
		String password=request.getParameter("password");
		String newpassword=request.getParameter("newpassword");
		String confirmpassword=request.getParameter("confirmpassword");
		
		//response.setContentType("text/html");
		try{
			  String driverClass="com.mysql.jdbc.Driver";
			  String url ="jdbc:mysql://zhang-pc:3306/vcard_manager";
			  Class.forName(driverClass);
			  Connection conn = DriverManager.getConnection(url,"root","root");
			  PreparedStatement ps1 =null; 
			  PreparedStatement ps2=null; 
			  String sql1="select password from user where id = ? limit 1";
			  String sql2= "update user set password=? where id=?";
			  ps1=conn.prepareStatement(sql1);
			  ps2=conn.prepareStatement(sql2);
			 
			  ps1.setInt(1, id);
			  
			  ps2.setString(1, newpassword);
			  ps2.setInt(2, id);
			  ResultSet rs1= ps1.executeQuery();
			  
			  if(rs1.next()){
				  
				  if(password.equals(rs1.getString("password"))){
					  //新密码
					  if(newpassword.equals(confirmpassword)){
						  ps2.executeUpdate();
						  response.sendRedirect("index.jsp");
					  }else{
						  request.setAttribute("failed", "两次密码输入不同，请重新输入！");
						  request.getRequestDispatcher("/changeinfo.jsp").forward(request,
									response);
					  }
				  }else{
					  request.setAttribute("failed", "原密码不正确");
					  request.getRequestDispatcher("/changeinfo.jsp").forward(request,
								response);
				  }
			  }else{
				  response.sendRedirect("servlet/LoginServlet.jsp");
			  }
			  return;
			  
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//out.flush();
		//out.close();
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	

}
