package fr.emn.eventmanager.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
		/*
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {
			List<Event> events = customer.getListOfEvent();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head> <title></title></head> ");
			out.println("  ");
			out.println("<body>");
			out.println("<table>");
			out.println("<th><td>Nom</td><td>Lieu</td><td>Début et fin</td></th>");
			for (Event event : events) {
				String location = event.getEventLocation();
				String name = event.getEventName();
				String start = event.getEventStartDatetime().toString();
				String end = event.getEventEndDatetime().toString();
				out.println("<tr><td>"+name+"</td><td>"+location+"</td><td>"+start+" - "+end+"</td></tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} else {
			//this.getServletContext().getRequestDispatcher("/subscribe.html").forward(request, response);
			response.sendRedirect("subscribe.html");
		}
		*/
		
		String route = request.getPathInfo();
		
			System.out.println("HomeController.doGet(): routing...");
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/view/HomeView.jsp");
			rd.forward(request, response);
		 
		
	}
	
}
