package fr.emn.eventmanager.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.emn.eventmanager.bean.Customer;
import fr.emn.eventmanager.persistence.service.CustomerPersistence;
import fr.emn.eventmanager.persistence.service.jpa.CustomerPersistenceJpa;

@WebServlet("/login")
public class AccountLoginController extends HttpServlet {

	public AccountLoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("AccountLoginController.doGet(): routing...");
		ServletContext context = getServletContext();
		RequestDispatcher rd = context
				.getRequestDispatcher("/WEB-INF/view/AccountLoginView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String password = request.getParameter("PasswordID");
		String email = request.getParameter("EmailID");

		CustomerPersistence customerPersistance = new CustomerPersistenceJpa();


		Map<String, Object> criteria = new HashMap<String, Object>(); //on recherche le customer par email
		criteria.put("customerEmail", email);
		List<Customer> users = customerPersistance.search(criteria);
		
		if (users.isEmpty()) //tester si liste vide = connexion impossible Customer non existant
		{
		ServletContext context = getServletContext();
		request.setAttribute("connexionImpossible", "Utilisateur non reconnu");
		System.out.println("connexionImpossible utilisateur non connu");
		RequestDispatcher rd = context
				.getRequestDispatcher("/WEB-INF/view/AccountLoginView.jsp");
		rd.forward(request, response);
		}

		else if(users.get(0).getCustomerPassword().equals(password)){           //on check que le password soit bon
			
			session.setAttribute("authentification", users.get(0));
			//ServletContext context = getServletContext();
			//RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/view/HomeCustomerView.jsp");
			//rd.forward(request, response);
			response.sendRedirect("/event-manager/home");
			System.out.println("connexion reussie, session ouverte");
		}
		else{
			//connexion impossible car mauvais password 
			ServletContext context = getServletContext();
			request.setAttribute("connexionImpossible", "Mot de passe errone");
			System.out.println("mauvais mdp");
			RequestDispatcher rd = context
					.getRequestDispatcher("/WEB-INF/view/AccountLoginView.jsp");
			rd.forward(request, response);
		}



	}

}
