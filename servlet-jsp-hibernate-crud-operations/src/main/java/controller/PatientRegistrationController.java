
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDao;
import dao.impl.PatientDaoImpl;
import entity.Patient;


@WebServlet("/patient/register")
public class PatientRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PatientDao patientDao = PatientDaoImpl.getInstance();

	public PatientRegistrationController() { 
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String custId = request.getParameter("id");
													
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		Patient patient = new Patient(firstName, lastName, email, mobile);

		if (custId == null || custId == "")
			patientDao.savePatient(patient);
		else {
			Long id = Long.parseLong(custId);
			patient.setId(id);
			patientDao.updatePatient(patient);
		}

		response.sendRedirect(request.getContextPath() + "/");
																
	}

}
