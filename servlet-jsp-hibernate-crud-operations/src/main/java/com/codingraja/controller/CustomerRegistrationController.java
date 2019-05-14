
package com.codingraja.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingraja.dao.CustomerDao;
import com.codingraja.dao.impl.CustomerDaoImpl;
import com.codingraja.domain.Customer;

@WebServlet("/customer/register")
public class CustomerRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerDao customerDao = CustomerDaoImpl.getInstance();

	public CustomerRegistrationController() { // Do Nothing
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/").forward(request, response);// Перенаправляет запрос на другую страницу.
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String custId = request.getParameter("id");// Возвращает значение параметра запроса в виде String, или nullесли
													// параметр не существует.
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		Customer customer = new Customer(firstName, lastName, email, mobile);

		if (custId == null || custId == "")
			customerDao.saveCustomer(customer);
		else {
			Long id = Long.parseLong(custId);// Анализирует указанную строку как десятичное длинное значение со знаком.
			customer.setId(id);
			customerDao.updateCustomer(customer);
		}

		response.sendRedirect(request.getContextPath() + "/");// Осуществляет редирект на заданную страницу(Возвращает
																// часть URI запроса, которая указывает контекст
																// запроса.)
	}

}
