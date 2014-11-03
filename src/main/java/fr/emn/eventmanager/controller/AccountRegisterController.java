package fr.emn.eventmanager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.emn.eventmanager.bean.Customer;
import fr.emn.eventmanager.persistence.service.CustomerPersistence;
import fr.emn.eventmanager.persistence.service.jpa.CustomerPersistenceJpa;

@WebServlet("/register")
public class AccountRegisterController extends HttpServlet {
	
	public AccountRegisterController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AccountRegisterController.doGet(): routing...");
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/view/AccountRegisterView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String firstname = request.getParameter("FirstNameID");
	String lastname = request.getParameter("NameID");
	String email = request.getParameter("EmailID");
	String company = request.getParameter("CompanyID");
	String password = request.getParameter("PasswordID");
	
	
	CustomerPersistence customerPersistance = new CustomerPersistenceJpa();
	
	Customer customer = new Customer();
	customer.setCustomerFirstname(firstname);
	customer.setCustomerLastname(lastname);
	customer.setCustomerEmail(email);
	customer.setCustomerCompany(company);
	customer.setCustomerPassword(password);
	customer.toString(); 								//test console
	customerPersistance.insert(customer);
	ServletContext context = getServletContext();
	RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/view/AccountLoginView.jsp");
	rd.forward(request, response);
	
	
	}
	
}
