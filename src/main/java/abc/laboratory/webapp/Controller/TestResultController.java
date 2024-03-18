package abc.laboratory.webapp.Controller;

import abc.laboratory.webapp.Model.TestResult;
import abc.laboratory.webapp.Service.TestResultService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/testResultController")
public class TestResultController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        TestResultService testResultService = TestResultService.getTestResultServiceInstance();

        if (type != null && type.equals("specific")) {
            getSpecificTestResult(request, response, testResultService);
        } else {
            getAllTestResults(request, response, testResultService);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        TestResultService testResultService = TestResultService.getTestResultServiceInstance();

        if (type != null && type.equals("update")) {
            updateTestResult(request, response, testResultService);
        } else if (type != null && type.equals("add")) {
            addTestResult(request, response, testResultService);
        } else if (type != null && type.equals("delete")) {
            deleteTestResult(request, response, testResultService);
        }
    }

    private void getAllTestResults(HttpServletRequest request, HttpServletResponse response, TestResultService service) throws ServletException, IOException {
        String message = "";
        List<TestResult> testResultList;

        try {
            testResultList = service.getAllTestResults();
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
            testResultList = null;
        }

        request.setAttribute("message", message);
        request.setAttribute("testResultList", testResultList);

        RequestDispatcher rd = request.getRequestDispatcher("TestResult.jsp");
        rd.forward(request, response);
    }

    private void getSpecificTestResult(HttpServletRequest request, HttpServletResponse response, TestResultService service) throws ServletException, IOException {
        String resultIdStr = request.getParameter("resultID");
        int resultID;
        TestResult testResult;
        String message = "";

        if (resultIdStr != null && !resultIdStr.isEmpty()) {
            try {
                resultID = Integer.parseInt(resultIdStr);
                testResult = service.getSpecificTestResult(resultID);
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                message = e.getMessage();
                testResult = new TestResult();
            }
        } else {
            message = "Result ID is missing or invalid.";
            testResult = new TestResult();
        }

        request.setAttribute("testResult", testResult);
        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("search-update-result.jsp");
        rd.forward(request, response);
    }

    private void updateTestResult(HttpServletRequest request, HttpServletResponse response, TestResultService service) throws ServletException, IOException {
        int resultID = Integer.parseInt(request.getParameter("resultID"));
        int appointmentID = Integer.parseInt(request.getParameter("appointmentID"));
        String result = request.getParameter("result");
        byte[] report = request.getParameter("report").getBytes(); // Assuming report is uploaded as byte array

        TestResult testResult = new TestResult(resultID, appointmentID, result, report);

        boolean resultFlag;
        String message = "";
        try {
            resultFlag = service.editTheTestResult(testResult);
            if (resultFlag) {
                message = "Test Result " + resultID + " has been successfully updated!";
            } else {
                message = "Failed to update the test result! Result ID: " + resultID;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("search-update-result.jsp");
        rd.forward(request, response);
    }

    private void addTestResult(HttpServletRequest request, HttpServletResponse response, TestResultService service) throws ServletException, IOException {
        int appointmentID = Integer.parseInt(request.getParameter("appointmentID"));
        String result = request.getParameter("result");
        byte[] report = request.getParameter("report").getBytes(); // Assuming report is uploaded as byte array

        TestResult testResult = new TestResult(appointmentID, result, report);

        boolean resultFlag;
        String message = "";
        try {
            resultFlag = service.registerTestResult(testResult);
            if (resultFlag) {
                message = "Test Result has been successfully added!";
            } else {
                message = "Failed to add the test result!";
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("add-result.jsp");
        rd.forward(request, response);
    }

    private void deleteTestResult(HttpServletRequest request, HttpServletResponse response, TestResultService service) throws ServletException, IOException {
        int resultID = Integer.parseInt(request.getParameter("resultID"));

        boolean resultFlag;
        String message = "";
        try {
            resultFlag = service.deleteTheTestResult(resultID);
            if (resultFlag) {
                message = "Test Result with ID " + resultID + " has been successfully deleted!";
            } else {
                message = "Failed to delete the test result with ID: " + resultID;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("TestResult.jsp");
        rd.forward(request, response);
    }
}