package fr.emn.eventmanager.controller;

import java.io.IOException;
import java.util.List;

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
import javax.servlet.http.HttpSession;

import fr.emn.eventmanager.bean.Customer;
import fr.emn.eventmanager.bean.Event;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	public HomeController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String home;
		if (session.getAttribute("authentification")!=null) {
			
			
			Customer c = (Customer) session.getAttribute("authentification");
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit1");
			EntityManager em = emf.createEntityManager();
			Query q = em.createNamedQuery("Event.getEventByCustomerId");
			q.setParameter("customerid", c.getCustomerId());
			List<Event> res = q.getResultList();
			
			
			request.setAttribute("listOfCreatedEvent", res);
			home = "/WEB-INF/view/HomeCustomerView.jsp";			
		} else {
			home = "/WEB-INF/view/HomeView.jsp";	
		}
		System.out.println("HomeController.doGet(): routing...");
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher(home);
		rd.forward(request, response);
	 }
}
