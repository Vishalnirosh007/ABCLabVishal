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

import abc.laboratory.webapp.Model.LabWorker;
import abc.laboratory.webapp.Service.LabWorkerService;

@WebServlet("/labWorkerController")
public class LabWorkerController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        LabWorkerService labWorkerService = LabWorkerService.getLabWorkerServiceInstance();

        if (type != null && type.equals("specific")) {
            getSpecificLabWorker(request, response, labWorkerService);
        } else {
            getAllLabWorkers(request, response, labWorkerService);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        LabWorkerService labWorkerService = LabWorkerService.getLabWorkerServiceInstance();

        if (type != null && type.equals("update")) {
            updateLabWorker(request, response, labWorkerService);
        } else if (type != null && type.equals("add")) {
            addLabWorker(request, response, labWorkerService);
        } else if (type != null && type.equals("delete")) {
            deleteLabWorker(request, response, labWorkerService);
        }
    }

    private void getAllLabWorkers(HttpServletRequest request, HttpServletResponse response,
            LabWorkerService service) throws ServletException, IOException {

        String message = "";
        List<LabWorker> labWorkerList;

        try {
            labWorkerList = service.getAllLabWorkers();
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
            labWorkerList = new ArrayList<>();
        }

        request.setAttribute("message", message);
        request.setAttribute("labWorkerList", labWorkerList);

        RequestDispatcher rd = request.getRequestDispatcher("LabworkerDashboard.jsp");
        rd.forward(request, response);
    }

    private void getSpecificLabWorker(HttpServletRequest request, HttpServletResponse response,
            LabWorkerService service) throws ServletException, IOException {
        String labWorkerIdStr = request.getParameter("labWorkerID");
        int labWorkerID;
        LabWorker labWorker;
        String message = "";

        if (labWorkerIdStr != null && !labWorkerIdStr.isEmpty()) {
            try {
                labWorkerID = Integer.parseInt(labWorkerIdStr);
                labWorker = service.getSpecificLabWorker(labWorkerID);
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                message = e.getMessage();
                labWorker = new LabWorker();
            }
        } else {
            message = "Lab Worker ID is missing or invalid.";
            labWorker = new LabWorker();
        }

        request.setAttribute("labWorker", labWorker);
        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Search-Worker.jsp");
        rd.forward(request, response);
    }

    private void updateLabWorker(HttpServletRequest request, HttpServletResponse response,
            LabWorkerService service) throws ServletException, IOException {
        int labWorkerID = Integer.parseInt(request.getParameter("labWorkerID"));
        String labWorkerName = request.getParameter("labWorkerName");
        String description = request.getParameter("description");

        LabWorker labWorker = new LabWorker(labWorkerName, description);
        labWorker.setLabWorkerID(labWorkerID);

        boolean result;
        String message = "";
        try {
            result = service.editTheLabWorker(labWorker);
            if (result) {
                message = "Lab Worker " + labWorkerID + " has been successfully updated!";
            } else {
                message = "Failed to update the lab worker! Lab Worker ID: " + labWorkerID;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Search-Worker.jsp");
        rd.forward(request, response);
    }

    private void addLabWorker(HttpServletRequest request, HttpServletResponse response,
            LabWorkerService service) throws ServletException, IOException {

        String labWorkerName = request.getParameter("labWorkerName");
        String description = request.getParameter("description");

        LabWorker labWorker = new LabWorker(labWorkerName, description);

        boolean result;
        String message = "";
        try {
            result = service.registerLabWorker(labWorker);
            if (result) {
                message = "Lab Worker " + labWorkerName + " has been successfully added!";
            } else {
                message = "Failed to add the lab worker! Lab Worker: " + labWorkerName;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Add-Worker.jsp");
        rd.forward(request, response);
    }

    private void deleteLabWorker(HttpServletRequest request, HttpServletResponse response,
            LabWorkerService service) throws ServletException, IOException {

        int labWorkerID = Integer.parseInt(request.getParameter("labWorkerID"));

        boolean result;
        String message = "";
        try {
            result = service.deleteTheLabWorker(labWorkerID);
            if (result) {
                message = "Lab Worker ID " + labWorkerID + " has been successfully deleted!";
            } else {
                message = "Failed to delete the lab worker! Lab Worker ID: " + labWorkerID;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        HttpSession session = request.getSession();

        try {
            List<LabWorker> labWorkerList = service.getAllLabWorkers();
            session.setAttribute("labWorkerList", labWorkerList);
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        session.setAttribute("message", message);
        response.sendRedirect("LabworkerDashboard.jsp");
    }
}
