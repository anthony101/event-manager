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
		String route = request.getPathInfo();
		if (route != null && route.equals("/new")) {
			System.out.println("EventController.doGet(): routing...");
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/view/EventNewView.jsp");
			rd.forward(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("NameID");
		String location = request.getParameter("LocationID");
		String start = request.getParameter("StartID");
		String end = request.getParameter("EndID");
		
		
		
		EventPersistence customerPersistance = new EventPersistenceJpa();
		
		Event event = new Event();
		event.setEventName(name);
		event.setEventLocation(location);
		SimpleDateFormat formatter = new SimpleDateFormat("JJ/MM/AA HH:MM");
		try {
			event.setEventStartDatetime(formatter.parse(start));
			event.setEventEndDatetime(formatter.parse(end));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int creatorId = ((Customer) request.getAttribute("customer")).getCustomerId();
		event.setEventCreatorId(Long.valueOf(creatorId));
		//TODO:MB: comment previous line and uncomment following line : 
		//event.setEventCreatorId(creatorId);
		event.toString(); 								//test console
		customerPersistance.insert(event);
	}
}
