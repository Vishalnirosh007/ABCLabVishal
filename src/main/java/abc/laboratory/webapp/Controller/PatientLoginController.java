package abc.laboratory.webapp.Controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import abc.laboratory.webapp.Service.PatientService;

@WebServlet("/patientLoginController")
public class PatientLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // You should implement your logic to validate the credentials here
            // For simplicity, let's assume you have a method in your service to validate credentials
            boolean isValid = PatientService.getPatientServiceInstance().validatePatientCredentials(username, password);

            if (isValid) {
                // If credentials are valid, redirect the patient to Patient.jsp
                response.sendRedirect("PatientHomePage.jsp");
            } else {
                // If credentials are not valid, show an error message on the login page
                request.setAttribute("errorMessage", "Invalid username or password");
                RequestDispatcher rd = request.getRequestDispatcher("Login-Patient.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            // Handle the ClassNotFoundException appropriately, such as logging or showing an error message
            e.printStackTrace(); // This is a simple way to handle it, you should improve this handling
            request.setAttribute("errorMessage", "An error occurred while processing your request");
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp"); // Create an error.jsp for showing error messages
            rd.forward(request, response);
        } catch (SQLException e) {
            // Handle the SQLException appropriately, such as logging or showing an error message
            e.printStackTrace(); // This is a simple way to handle it, you should improve this handling
            request.setAttribute("errorMessage", "An error occurred while processing your request");
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp"); // Create an error.jsp for showing error messages
            rd.forward(request, response);
        }
    }
}



