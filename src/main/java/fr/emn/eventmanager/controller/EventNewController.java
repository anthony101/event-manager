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

import fr.emn.eventmanager.bean.Customer;
import fr.emn.eventmanager.bean.Event;
import fr.emn.eventmanager.persistence.service.CustomerPersistence;
import fr.emn.eventmanager.persistence.service.EventPersistence;
import fr.emn.eventmanager.persistence.service.jpa.CustomerPersistenceJpa;
import fr.emn.eventmanager.persistence.service.jpa.EventPersistenceJpa;

@WebServlet("/event/new")
public class EventNewController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public EventNewController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EventController.doGet(): routing...");
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/view/EventNewView.jsp");
		rd.forward(request, response);
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
		//event.setEventStartDatetime(start);   caster string en date ?
		//event.setEventEndDatetime(end);		caster string en date ?
		//event.setEventCreatorId(eventCreatorId);
		
		event.toString(); 								//test console
		customerPersistance.insert(event);
	
	}
}
