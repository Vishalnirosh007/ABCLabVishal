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

import abc.laboratory.webapp.Model.Checkup;
import abc.laboratory.webapp.Service.CheckupService;



@WebServlet("/checkupController")
public class CheckupController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        CheckupService checkupService = CheckupService.getCheckupServiceInstance();

        if (type != null && type.equals("specific")) {
            getSpecificCheckup(request, response, checkupService);
        } else {
            getAllCheckups(request, response, checkupService);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        CheckupService checkupService = CheckupService.getCheckupServiceInstance();

        if (type != null && type.equals("update")) {
            updateCheckup(request, response, checkupService);
        } else if (type != null && type.equals("add")) {
            addCheckup(request, response, checkupService);
        } else if (type != null && type.equals("delete")) {
            deleteCheckup(request, response, checkupService);
        }
    }

    private void getAllCheckups(HttpServletRequest request, HttpServletResponse response, CheckupService service) throws ServletException, IOException {
        String message = "";
        List<Checkup> checkupList;

        try {
            checkupList = service.getAllCheckups();
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
            checkupList = new ArrayList<>();
        }

        request.setAttribute("message", message);
        request.setAttribute("checkupList", checkupList);

        RequestDispatcher rd = request.getRequestDispatcher("CheckupDashboard.jsp");
        rd.forward(request, response);
    }

    private void getSpecificCheckup(HttpServletRequest request, HttpServletResponse response, CheckupService service) throws ServletException, IOException {
        String checkupIdStr = request.getParameter("checkupID");
        int checkupId;
        Checkup checkup;
        String message = "";

        if (checkupIdStr != null && !checkupIdStr.isEmpty()) {
            try {
                checkupId = Integer.parseInt(checkupIdStr);
                checkup = service.getSpecificCheckup(checkupId);
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                message = e.getMessage();
                checkup = new Checkup();
            }
        } else {
            message = "Checkup ID is missing or invalid.";
            checkup = new Checkup();
        }

        request.setAttribute("checkup", checkup);
        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Search-Checkup-Details.jsp");
        rd.forward(request, response);
    }

    private void updateCheckup(HttpServletRequest request, HttpServletResponse response, CheckupService service) throws ServletException, IOException {
        int checkupId = Integer.parseInt(request.getParameter("checkupID"));
        String name = request.getParameter("checkupName");
        String costParam = request.getParameter("checkupCost");
        String description = request.getParameter("checkupDescription");

        double cost = 0.0; // Default value if costParam is null
        if (costParam != null && !costParam.isEmpty()) {
            cost = Double.parseDouble(costParam);
        }

        Checkup checkup = new Checkup(checkupId, name, cost, description);

        boolean result;
        String message = "";
        try {
            result = service.editTheCheckup(checkup);
            if (result) {
                message = "Checkup " + checkupId + " has been successfully updated!";
            } else {
                message = "Failed to update the checkup! Checkup ID: " + checkupId;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Search-Checkup-Details.jsp");
        rd.forward(request, response);
    }

    private void addCheckup(HttpServletRequest request, HttpServletResponse response, CheckupService service) throws ServletException, IOException {
        String name = request.getParameter("checkupName");
        String costParam = request.getParameter("checkupCost");
        String description = request.getParameter("checkupDescription");

        double cost = 0.0; // Default value if costParam is null
        if (costParam != null && !costParam.isEmpty()) {
            cost = Double.parseDouble(costParam);
        }

        Checkup checkup = new Checkup(name, cost, description);

        boolean result;
        String message = "";
        try {
            result = service.registerCheckup(checkup);
            if (result) {
                message = "Checkup " + name + " has been successfully added!";
            } else {
                message = "Failed to add the checkup! Checkup: " + name;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Add-Checkup-Details.jsp");
        rd.forward(request, response);
    }

    private void deleteCheckup(HttpServletRequest request, HttpServletResponse response, CheckupService service) throws ServletException, IOException {
        int checkupId = Integer.parseInt(request.getParameter("checkupID"));

        boolean result;
        String message = "";
        try {
            result = service.deleteTheCheckup(checkupId);
            if (result) {
                message = "Checkup ID " + checkupId + " has been successfully deleted!";
            } else {
                message = "Failed to delete the checkup! Checkup ID: " + checkupId;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        HttpSession session = request.getSession();

        try {
            List<Checkup> checkupList = service.getAllCheckups();
            session.setAttribute("checkupList", checkupList);
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        session.setAttribute("message", message);
        response.sendRedirect("CheckupDashboard.jsp");
    }
}