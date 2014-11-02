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

@WebServlet("/account/login")
public class AccountLoginController extends HttpServlet {

	public AccountLoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("AccountController.doGet(): routing...");
		ServletContext context = getServletContext();
		RequestDispatcher rd = context
				.getRequestDispatcher("/WEB-INF/view/AccountLoginView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String password = request.getParameter("PasswordID");
		String email = request.getParameter("emailID");

		CustomerPersistence customerPersistance = new CustomerPersistenceJpa();
		
		
		Map<String, Object> criteria = new HashMap<String, Object>();
		criteria.put("customerEmail", email);
		List<Customer> users = customerPersistance.search(criteria);
		//tester si liste vide = connexion impossible
		
		//code si connexion impossible
		ServletContext context = getServletContext();
		request.setAttribute("connexionImpossible", true);
		RequestDispatcher rd = context
				.getRequestDispatcher("/WEB-INF/view/AccountLoginView.jsp");
		rd.forward(request, response);
		
		if(users.get(0).getCustomerPassword().equals(password)){
			session.setAttribute("authentification", users.get(0));
		}
		else{
			//connexion impossible
		}

		

	}

}
