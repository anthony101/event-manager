package fr.emn.eventmanager.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.emn.eventmanager.bean.Customer;
import fr.emn.eventmanager.bean.Event;
import fr.emn.eventmanager.bean.Participant;
import fr.emn.eventmanager.persistence.service.CustomerPersistence;
import fr.emn.eventmanager.persistence.service.EventPersistence;
import fr.emn.eventmanager.persistence.service.ParticipantPersistence;
import fr.emn.eventmanager.persistence.service.jpa.CustomerPersistenceJpa;
import fr.emn.eventmanager.persistence.service.jpa.EventPersistenceJpa;
import fr.emn.eventmanager.persistence.service.jpa.ParticipantPersistenceJpa;

/**
 * Servlet implementation class EventSubscribeController
 */
@WebServlet("/event/subscribe/*")
public class EventSubscribeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventSubscribeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getPathInfo().replaceFirst("/event/subscribe/", "");
		try {
			int eventId = Integer.parseInt(id.replaceFirst("/", ""));
			//EventPersistence ep = new EventPersistenceJpa();
			//Event event = ep.load(eventId);
			Event event = new Event();
			event.setEventId(eventId);
			request.setAttribute("event", event);
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/view/EventSubscribeView.jsp");
			rd.forward(request, response);
		} catch (NumberFormatException e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String firstname = request.getParameter("FirstNameID");
		String lastname = request.getParameter("NameID");
		String email = request.getParameter("EmailID");
		String company = request.getParameter("CompanyID");
		Customer customer = new Customer();
		customer.setCustomerFirstname(firstname);
		customer.setCustomerLastname(lastname);
		customer.setCustomerEmail(email);
		customer.setCustomerCompany(company);
		CustomerPersistence cp = new CustomerPersistenceJpa();
		cp.insert(customer);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit1");
		EntityManager em = emf.createEntityManager();
		Query q = em.createNamedQuery("Customer.getCustomerByEmail");
		q.setParameter("customeremail", email);
		int customerId = ((Customer) q.getResultList().get(0)).getCustomerId();
		
		String id = request.getPathInfo().replaceFirst("/event/subscribe/", "");
		try {
			int eventId = Integer.parseInt(id.replaceFirst("/", ""));
			Participant p = new Participant();
			p.setParticipantCustomerId(customerId);
			p.setParticipantEventId(eventId);
			ParticipantPersistence pp = new ParticipantPersistenceJpa();
			pp.insert(p);
			response.sendRedirect("/event-manager/event/" + eventId);
		} catch (NumberFormatException e) {
			
		}
		
		
	}

}
