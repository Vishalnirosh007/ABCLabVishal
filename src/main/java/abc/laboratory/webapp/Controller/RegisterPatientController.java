package abc.laboratory.webapp.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import abc.laboratory.webapp.Model.Patient;

import abc.laboratory.webapp.Service.RegisterPatientService;

@WebServlet("/registerPatientController")
public class RegisterPatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        RegisterPatientService registerpatientService = RegisterPatientService.getRegisterpatientServiceInstance();

        if (type != null && type.equals("add")) {
            addPatient(request, response, registerpatientService);
        }
    }



	 private void addPatient(HttpServletRequest request, HttpServletResponse response,
			RegisterPatientService service) throws ServletException, IOException {
		  String patientFullName = request.getParameter("patientFullName");
	        int patientPhoneNumber = Integer.parseInt(request.getParameter("patientPhoneNumber"));
	        String dateOfBirth = request.getParameter("dateOfBirth");
	        String patientAddress = request.getParameter("patientAddress");
	        String gender = request.getParameter("gender");
	        String patientEmail = request.getParameter("patientEmail");
	        String patientUsername = request.getParameter("patientUsername");
	        String patientPassword = request.getParameter("patientPassword");

	        Patient patient = new Patient(patientFullName, patientPhoneNumber, dateOfBirth, patientAddress, gender, patientEmail, patientUsername, patientPassword);

	        boolean result;
	        String message = "";
	        try {
	            result = service.registerPatient(patient);
	            if (result) {
	                message = "Patient " + patientFullName + " has been successfully added!";
	            } else {
	                message = "Failed to add the patient!";
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            message = e.getMessage();
	        }

	        request.setAttribute("message", message);

	        RequestDispatcher rd = request.getRequestDispatcher("PatientRegister.jsp");
	        rd.forward(request, response);
		
	}




	


}
