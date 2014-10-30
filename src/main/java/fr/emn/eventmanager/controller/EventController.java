package fr.emn.eventmanager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.apt.dispatch.RoundDispatcher;

@WebServlet("/event/*")
public class EventController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public EventController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String route = request.getPathInfo();
		if (route != null && route.equals("/new")) {
			System.out.println("EventController.doGet(): routing...");
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/view/EventNew.jsp");
			rd.forward(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
