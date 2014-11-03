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
import javax.servlet.http.HttpSession;

import fr.emn.eventmanager.bean.Customer;
import fr.emn.eventmanager.bean.Event;
import fr.emn.eventmanager.persistence.service.EventPersistence;
import fr.emn.eventmanager.persistence.service.jpa.EventPersistenceJpa;

@WebServlet("/event/new")
public class EventNewController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public EventNewController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EventController.doGet(): routing...");
		
		HttpSession session = request.getSession();
		if (session.getAttribute("authentification") != null) {
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/view/EventNewView.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("authentification") == null) {
			response.sendRedirect("/login");
		}
		
		String name = request.getParameter("NameID");
		String location = request.getParameter("LocationID");
		String start = request.getParameter("StartID");
		String end = request.getParameter("EndID");

		EventPersistence customerPersistance = new EventPersistenceJpa();
		
		Event event = new Event();
		event.setEventName(name);
		event.setEventLocation(location);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YY HH:MM");
		try {
			event.setEventStartDatetime(formatter.parse(start));
			event.setEventEndDatetime(formatter.parse(end));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Customer customer = (Customer) session.getAttribute("authentification");
		event.setCustomer(customer);
		event.toString(); //test console
		customerPersistance.insert(event);
	}
}
