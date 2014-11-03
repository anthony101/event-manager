package fr.emn.eventmanager.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.apt.dispatch.RoundDispatcher;

import fr.emn.eventmanager.bean.Customer;
import fr.emn.eventmanager.bean.Event;
import fr.emn.eventmanager.persistence.service.CustomerPersistence;
import fr.emn.eventmanager.persistence.service.EventPersistence;
import fr.emn.eventmanager.persistence.service.jpa.CustomerPersistenceJpa;
import fr.emn.eventmanager.persistence.service.jpa.EventPersistenceJpa;

@WebServlet("/event/*")
public class EventController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public EventController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String route = request.getPathInfo();
		
		if (route != null && route.equals("/new")) {
			System.out.println("EventController.doGet(): routing...");
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/view/EventNewView.jsp");
			rd.forward(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}*/
		
		String id = request.getPathInfo().replaceFirst("/", "");
		try {
			int eventId = Integer.parseInt(id);
			EventPersistence ep = new EventPersistenceJpa();
			Event event = ep.load(eventId);
			request.setAttribute("event", event);
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/view/EventView.jsp");
			rd.forward(request, response);
		} catch (NumberFormatException e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
