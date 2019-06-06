package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDao;
import dao.impl.PatientDaoImpl;

@WebServlet("/patient/delete")
public class DeletePatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeletePatientController() { // Do Nothing
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String custId = request.getParameter("custId");

		if (custId == "" || custId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long id = Long.parseLong(custId);
			PatientDao patientDao = PatientDaoImpl.getInstance();

			patientDao.deletePatient(id);

			response.sendRedirect(request.getContextPath() + "/");
		}
	}
}
