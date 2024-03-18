package abc.laboratory.webapp.Controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import abc.laboratory.webapp.Model.Patient;
import abc.laboratory.webapp.Service.PatientService;

@WebServlet("/patientController")
public class PatientController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        PatientService patientService = PatientService.getPatientServiceInstance();

        if (type != null && type.equals("specific")) {
            getSpecificPatient(request, response, patientService);
        } else {
            getAllPatients(request, response, patientService);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        PatientService patientService = PatientService.getPatientServiceInstance();

        if (type != null && type.equals("update")) {
            updatePatient(request, response, patientService);
        } else if (type != null && type.equals("add")) {
            addPatient(request, response, patientService);
        } else if (type != null && type.equals("delete")) {
            deletePatient(request, response, patientService);
        }
    }

    private void getAllPatients(HttpServletRequest request, HttpServletResponse response, PatientService service) throws ServletException, IOException {
        String message = "";
        List<Patient> patientList;

        try {
            patientList = service.getAllPatients();
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
            patientList = new ArrayList<>();
        }

        request.setAttribute("message", message);
        request.setAttribute("patientList", patientList);

        RequestDispatcher rd = request.getRequestDispatcher("PatientDashboard.jsp");
        rd.forward(request, response);
    }

    private void getSpecificPatient(HttpServletRequest request, HttpServletResponse response, PatientService service) throws ServletException, IOException {
        String patientIdStr = request.getParameter("patientID");
        int patientID;
        Patient patient;
        String message = "";

        if (patientIdStr != null && !patientIdStr.isEmpty()) {
            try {
            	patientID = Integer.parseInt(patientIdStr);
                patient = service.getSpecificPatient(patientID);
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                message = e.getMessage();
                patient = new Patient();
            }
        } else {
            message = "Patient ID is missing or invalid.";
            patient = new Patient();
        }

        request.setAttribute("patient", patient);
        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Search-Patient-Details.jsp");
        rd.forward(request, response);
    }

    private void updatePatient(HttpServletRequest request, HttpServletResponse response, PatientService service) throws ServletException, IOException {
        int patientID = Integer.parseInt(request.getParameter("patientID"));
        String patientFullName = request.getParameter("patientFullName");
        int patientPhoneNumber = Integer.parseInt(request.getParameter("patientPhoneNumber"));
        String dateOfBirth = request.getParameter("dateOfBirth");
        String patientAddress = request.getParameter("patientAddress");
        String gender = request.getParameter("gender");
        String patientEmail = request.getParameter("patientEmail");
        String patientUsername = request.getParameter("patientUsername");
        String patientPassword = request.getParameter("patientPassword");

        Patient patient = new Patient(patientFullName, patientPhoneNumber, dateOfBirth, patientAddress, gender, patientEmail, patientUsername, patientPassword);
        patient.setPatientID(patientID);

        boolean result;
        String message = "";
        try {
            result = service.editThePatient(patient);
            if (result) {
                message = "Patient " + patientID + " has been successfully updated!";
            } else {
                message = "Failed to update the patient! Patient ID: " + patientID;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Search-Patient-Details.jsp");
        rd.forward(request, response);
    }

    private void addPatient(HttpServletRequest request, HttpServletResponse response, PatientService service) throws ServletException, IOException {
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

        RequestDispatcher rd = request.getRequestDispatcher("Add-Patient-Details.jsp");
        rd.forward(request, response);
    }

    private void deletePatient(HttpServletRequest request, HttpServletResponse response, PatientService service) throws ServletException, IOException {
        int patientID = Integer.parseInt(request.getParameter("patientID"));

        boolean result;
        String message = "";
        try {
            result = service.deleteThePatient(patientID);
            if (result) {
                message = "Patient with ID " + patientID + " has been successfully deleted!";
            } else {
                message = "Failed to delete the patient with ID: " + patientID;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        HttpSession session = request.getSession();

        try {
            List<Patient> patientList = service.getAllPatients();
            session.setAttribute("patientList", patientList);
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        session.setAttribute("message", message);
        response.sendRedirect("PatientDashboard.jsp");
    }
}
