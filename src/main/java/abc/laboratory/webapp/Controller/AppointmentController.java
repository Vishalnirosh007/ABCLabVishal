package abc.laboratory.webapp.Controller;

import abc.laboratory.webapp.Model.Appointment;
import abc.laboratory.webapp.Service.AppointmentService;

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

@WebServlet("/appointmentController")
public class AppointmentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        AppointmentService appointmentService = AppointmentService.getAppointmentServiceInstance();

        if (type != null && type.equals("specific")) {
            getSpecificAppointment(request, response, appointmentService);
        } else {
            getAllAppointments(request, response, appointmentService);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        AppointmentService appointmentService = AppointmentService.getAppointmentServiceInstance();

        if (type != null && type.equals("update")) {
            updateAppointment(request, response, appointmentService);
        } else if (type != null && type.equals("add")) {
            scheduleAppointment(request, response, appointmentService);
        } else if (type != null && type.equals("delete")) {
            cancelAppointment(request, response, appointmentService);
        }
    }

    private void getAllAppointments(HttpServletRequest request, HttpServletResponse response,
                                    AppointmentService service) throws ServletException, IOException {

        String message = "";
        List<Appointment> appointmentList;

        try {
            appointmentList = service.getAllAppointments();
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
            appointmentList = new ArrayList<>();
        }

        request.setAttribute("message", message);
        request.setAttribute("appointmentList", appointmentList);

        RequestDispatcher rd = request.getRequestDispatcher("AppointmentDashboard.jsp");
        rd.forward(request, response);
    }

    private void getSpecificAppointment(HttpServletRequest request, HttpServletResponse response,
                                        AppointmentService service) throws ServletException, IOException {
        String appointmentIdStr = request.getParameter("appointmentId");
        int appointmentId;
        Appointment appointment;
        String message = "";

        if (appointmentIdStr != null && !appointmentIdStr.isEmpty()) {
            try {
                appointmentId = Integer.parseInt(appointmentIdStr);
                appointment = service.getSpecificAppointment(appointmentId);
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                message = e.getMessage();
                appointment = new Appointment();
            }
        } else {
            message = "Appointment ID is missing or invalid.";
            appointment = new Appointment();
        }

        request.setAttribute("appointment", appointment);
        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Search-Appointment.jsp");
        rd.forward(request, response);
    }

    private void updateAppointment(HttpServletRequest request, HttpServletResponse response, AppointmentService service) throws ServletException, IOException {
        String appointmentIdStr = request.getParameter("appointmentId");
        int appointmentId = 0; // Default value if parameter is null or empty
        if (appointmentIdStr != null && !appointmentIdStr.isEmpty()) {
            appointmentId = Integer.parseInt(appointmentIdStr);
        }

        String appointmentDate = request.getParameter("appointmentDate");
        String doctorName = request.getParameter("doctorName");
        String checkupName = request.getParameter("checkupName");
        String labWorkerName = request.getParameter("labWorkerName");
        int patientId = 0;
        if(request.getParameter("patientId") != null && !request.getParameter("patientId").isEmpty()) {
            patientId = Integer.parseInt(request.getParameter("patientId"));
        }
        int checkupId = 0;
        if(request.getParameter("checkupId") != null && !request.getParameter("checkupId").isEmpty()) {
            checkupId = Integer.parseInt(request.getParameter("checkupId"));
        }
        int doctorId = 0;
        if(request.getParameter("doctorId") != null && !request.getParameter("doctorId").isEmpty()) {
            doctorId = Integer.parseInt(request.getParameter("doctorId"));
        }
        int labWorkerId = 0;
        if(request.getParameter("labWorkerId") != null && !request.getParameter("labWorkerId").isEmpty()) {
            labWorkerId = Integer.parseInt(request.getParameter("labWorkerId"));
        }
        String appointmentStatus = request.getParameter("appointmentStatus");

        Appointment appointment = new Appointment(appointmentId, appointmentDate, doctorName, checkupName, labWorkerName,
                patientId, checkupId, doctorId, labWorkerId, appointmentStatus);

        String message = "";
        try {
            boolean result = service.updateAppointmentDetails(appointment);
            if (result) {
                message = "Appointment " + appointmentId + " has been successfully updated!";
            } else {
                message = "Failed to update the appointment! Appointment ID: " + appointmentId;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = "Error updating appointment: " + e.getMessage();
            e.printStackTrace(); // Log the exception for debugging purposes
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Search-Appointment.jsp");
        rd.forward(request, response);
    }


    private void scheduleAppointment(HttpServletRequest request, HttpServletResponse response,
                                     AppointmentService service) throws ServletException, IOException {
    	String appointmentDate = request.getParameter("appointmentDate");
    	String doctorName = request.getParameter("doctorName");
        String checkupName = request.getParameter("checkupName");
        String labWorkerName = request.getParameter("labWorkerName");
        int patientId = Integer.parseInt(request.getParameter("patientId"));
        int checkupId = Integer.parseInt(request.getParameter("checkupId"));
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        int labWorkerId = Integer.parseInt(request.getParameter("labWorkerId"));
        String appointmentStatus = request.getParameter("appointmentStatus");

        Appointment appointment = new Appointment(0, appointmentDate, doctorName, checkupName, labWorkerName,
                patientId, checkupId, doctorId, labWorkerId, appointmentStatus);

        boolean result;
        String message = "";
        try {
            result = service.scheduleAppointment(appointment);
            if (result) {
                message = "Appointment has been successfully scheduled!";
            } else {
                message = "Failed to schedule the appointment!";
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Add-Appointment.jsp");
        rd.forward(request, response);
    }

    private void cancelAppointment(HttpServletRequest request, HttpServletResponse response,
                                   AppointmentService service) throws ServletException, IOException {
    	int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));

        boolean result;
        String message = "";
        try {
            result = service.cancelAppointment(appointmentId);
            if (result) {
                message = "Appointment " + appointmentId + " has been successfully canceled!";
            } else {
                message = "Failed to cancel the appointment! Appointment ID: " + appointmentId;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        HttpSession session = request.getSession();

        try {
            List<Appointment> appointmentList = service.getAllAppointments();
            session.setAttribute("appointmentList", appointmentList);
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        session.setAttribute("message", message);
        response.sendRedirect("AppointmentDashboard.jsp");
    }
}

