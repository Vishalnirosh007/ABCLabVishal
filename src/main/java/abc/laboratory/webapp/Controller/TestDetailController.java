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

import abc.laboratory.webapp.Model.TestDetail;
import abc.laboratory.webapp.Service.TestDetailService;

/**
 * Servlet implementation class TestDetailController
 */
@WebServlet("/testDetailController")
public class TestDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        TestDetailService testDetailService = TestDetailService.getTestDetailServiceInstance();

        { 
            getAllTestDetails(request, response, testDetailService);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        TestDetailService testDetailService = TestDetailService.getTestDetailServiceInstance();

       
        if (type != null && type.equals("add")) {
            addTestDetail(request, response, testDetailService);
        } else if (type != null && type.equals("delete")) {
            deleteTestDetail(request, response, testDetailService);
        }
    }

    private void getAllTestDetails(HttpServletRequest request, HttpServletResponse response, TestDetailService service) throws ServletException, IOException {
        String message = "";
        List<TestDetail> testDetailList;

        try {
            testDetailList = service.getAllTestDetails();
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
            testDetailList = new ArrayList<>();
        }

        request.setAttribute("message", message);
        request.setAttribute("testDetailList", testDetailList);

        RequestDispatcher rd = request.getRequestDispatcher("TestDetailDashboard.jsp");
        rd.forward(request, response);
    }


    private void addTestDetail(HttpServletRequest request, HttpServletResponse response, TestDetailService service) throws ServletException, IOException {
        int appointmentID = Integer.parseInt(request.getParameter("appointmentID"));
        String technicianName = request.getParameter("technicianName");
        String doctorName = request.getParameter("doctorName");

        TestDetail testDetail = new TestDetail(appointmentID, technicianName, doctorName);

        boolean result;
        String message = "";
        try {
            result = service.registerTestDetail(testDetail);
            if (result) {
                message = "Test Detail has been successfully added!";
            } else {
                message = "Failed to add the test detail!";
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Add-Testdetail.jsp");
        rd.forward(request, response);
    }

    private void deleteTestDetail(HttpServletRequest request, HttpServletResponse response, TestDetailService service) throws ServletException, IOException {
        int testDetailId = Integer.parseInt(request.getParameter("testdetailid"));

        boolean result;
        String message = "";
        try {
            result = service.deleteTheTestDetail(testDetailId);
            if (result) {
                message = "Test Detail " + testDetailId + " has been successfully deleted!";
            } else {
                message = "Failed to delete the test detail! Test Detail ID: " + testDetailId;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        HttpSession session = request.getSession();

        try {
            List<TestDetail> testDetailList = service.getAllTestDetails();
            session.setAttribute("testDetailList", testDetailList);
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        session.setAttribute("message", message);
        response.sendRedirect("TestDetailDashboard.jsp");
    }

}
