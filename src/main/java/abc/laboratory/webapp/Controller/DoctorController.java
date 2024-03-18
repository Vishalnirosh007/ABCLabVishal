package abc.laboratory.webapp.Controller;

import abc.laboratory.webapp.Model.Doctor;
import abc.laboratory.webapp.Service.DoctorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/doctorController")
public class DoctorController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        DoctorService doctorService = DoctorService.getDoctorServiceInstance();

        if (type != null && type.equals("specific")) {
            getSpecificDoctor(request, response, doctorService);
        } else {
            getAllDoctors(request, response, doctorService);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        DoctorService doctorService = DoctorService.getDoctorServiceInstance();

        if (type != null && type.equals("update")) {
            updateDoctor(request, response, doctorService);
        } else if (type != null && type.equals("add")) {
            addDoctor(request, response, doctorService);
        } else if (type != null && type.equals("delete")) {
            deleteDoctor(request, response, doctorService);
        }
    }

    private void getAllDoctors(HttpServletRequest request, HttpServletResponse response, DoctorService service) throws ServletException, IOException {
        String message = "";
        List<Doctor> doctorList;

        try {
            doctorList = service.getAllDoctors();
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
            doctorList = new ArrayList<>();
        }

        request.setAttribute("message", message);
        request.setAttribute("doctorList", doctorList);

        RequestDispatcher rd = request.getRequestDispatcher("DoctorDashboard.jsp");
        rd.forward(request, response);
    }

    private void getSpecificDoctor(HttpServletRequest request, HttpServletResponse response, DoctorService service) throws ServletException, IOException {
        String doctorIdStr = request.getParameter("doctorId");
        int doctorId;
        Doctor doctor;
        String message = "";

        if (doctorIdStr != null && !doctorIdStr.isEmpty()) {
            try {
                doctorId = Integer.parseInt(doctorIdStr);
                doctor = service.getSpecificDoctor(doctorId);
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                message = e.getMessage();
                doctor = new Doctor();
            }
        } else {
            message = "Doctor ID is missing or invalid.";
            doctor = new Doctor();
        }

        request.setAttribute("doctor", doctor);
        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Search-Doctor-Details.jsp");
        rd.forward(request, response);
    }

    private void updateDoctor(HttpServletRequest request, HttpServletResponse response, DoctorService service) throws ServletException, IOException {
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String specialization = request.getParameter("specialization");
        String email = request.getParameter("email");

        Doctor doctor = new Doctor(doctorId, firstName, lastName, specialization, email);

        boolean result;
        String message = "";
        try {
            result = service.editTheDoctor(doctor);
            if (result) {
                message = "Doctor " + doctorId + " has been successfully updated!";
            } else {
                message = "Failed to update the doctor! Doctor ID: " + doctorId;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Search-Doctor-Details.jsp");
        rd.forward(request, response);
    }

    private void addDoctor(HttpServletRequest request, HttpServletResponse response, DoctorService service) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String specialization = request.getParameter("specialization");
        String email = request.getParameter("email");

        Doctor doctor = new Doctor(firstName, lastName, specialization, email);

        boolean result;
        String message = "";
        try {
            result = service.registerDoctor(doctor);
            if (result) {
                message = "Doctor " + firstName + " " + lastName + " has been successfully added!";
            } else {
                message = "Failed to add the doctor! Doctor: " + firstName + " " + lastName;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Add-Doctor-Details.jsp");
        rd.forward(request, response);
    }

    private void deleteDoctor(HttpServletRequest request, HttpServletResponse response, DoctorService service) throws ServletException, IOException {
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));

        boolean result;
        String message = "";
        try {
            result = service.deleteTheDoctor(doctorId);
            if (result) {
                message = "Doctor ID " + doctorId + " has been successfully deleted!";
            } else {
                message = "Failed to delete the doctor! Doctor ID: " + doctorId;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        HttpSession session = request.getSession();

        try {
            List<Doctor> doctorList = service.getAllDoctors();
            session.setAttribute("doctorList", doctorList);
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        session.setAttribute("message", message);
        response.sendRedirect("DoctorDashboard.jsp");
    }
}