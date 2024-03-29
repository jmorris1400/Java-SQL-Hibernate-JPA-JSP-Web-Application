package com.file.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.file.model.User;
import com.file.service.LoginService;


public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

	 String userId = request.getParameter("userId");	
	 String password = request.getParameter("password");

	// simple validation. 
	 LoginService loginService = new LoginService();
	 //if object true, meaing correct credentials, passing in two variables

	 boolean result = loginService.authenticateUser(userId, password);
	 User user = loginService.getUserByUserId(userId);

	 //page will redirect you to the home page if creditails line up
	 if(result == true){
		 request.getSession().setAttribute("user", user);		
		 response.sendRedirect("home.jsp");
	 }
	 else{
		 response.sendRedirect("error.jsp");
	 }
}

}