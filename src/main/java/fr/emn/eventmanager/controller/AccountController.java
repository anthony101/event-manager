package fr.emn.eventmanager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/account/*")
public class AccountController extends HttpServlet {
	
	public AccountController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String route = request.getPathInfo();
		if (route != null && route.equals("/login")) {
			System.out.println("AccountController.doGet(): routing...");
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/view/AccountLoginView.jsp");
			rd.forward(request, response);
		} 
		else if (route != null && route.equals("/register")) {
			System.out.println("AccountController.doGet(): routing...");
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/view/AccountRegisterView.jsp");
			rd.forward(request, response);
		} 
		
		
		else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println(request.getParameter("passwordRegister"));
	}
	
}
