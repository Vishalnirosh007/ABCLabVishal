package abc.laboratory.webapp.Controller;


import abc.laboratory.webapp.Model.Payment;
import abc.laboratory.webapp.Service.PaymentService;

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

@WebServlet("/paymentController")
public class PaymentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        PaymentService paymentService = PaymentService.getPaymentServiceInstance();

        if (type != null && type.equals("specific")) {
            getSpecificPayment(request, response, paymentService);
        } else {
            getAllPayments(request, response, paymentService);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        PaymentService paymentService = PaymentService.getPaymentServiceInstance();

        if (type != null && type.equals("update")) {
            updatePayment(request, response, paymentService);
        } else if (type != null && type.equals("add")) {
            processPayment(request, response, paymentService);
        } else if (type != null && type.equals("delete")) {
            cancelPayment(request, response, paymentService);
        }
    }

    private void getAllPayments(HttpServletRequest request, HttpServletResponse response, PaymentService service) throws ServletException, IOException {
        String message = "";
        List<Payment> paymentList;

        try {
            paymentList = service.getAllPayments();
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
            paymentList = new ArrayList<>();
        }

        request.setAttribute("message", message);
        request.setAttribute("paymentList", paymentList);

        RequestDispatcher rd = request.getRequestDispatcher("PaymentDashboard.jsp");
        rd.forward(request, response);
    }

    private void getSpecificPayment(HttpServletRequest request, HttpServletResponse response, PaymentService service) throws ServletException, IOException {
        String paymentIdStr = request.getParameter("paymentId");
        int paymentId;
        Payment payment;
        String message = "";

        if (paymentIdStr != null && !paymentIdStr.isEmpty()) {
            try {
                paymentId = Integer.parseInt(paymentIdStr);
                payment = service.getSpecificPayment(paymentId);
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                message = e.getMessage();
                payment = new Payment();
            }
        } else {
            message = "Payment ID is missing or invalid.";
            payment = new Payment();
        }

        request.setAttribute("payment", payment);
        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Search-Payment.jsp");
        rd.forward(request, response);
    }

    private void updatePayment(HttpServletRequest request, HttpServletResponse response, PaymentService service) throws ServletException, IOException {
        int paymentId = Integer.parseInt(request.getParameter("paymentId"));
        double price = Double.parseDouble(request.getParameter("price"));
        String cardholderName = request.getParameter("cardholderName");
        int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
        String expiryDate = request.getParameter("expiryDate");
        int cvcNumber = Integer.parseInt(request.getParameter("cvcNumber"));
        String paymentDate = request.getParameter("paymentDate");
        int patientId = Integer.parseInt(request.getParameter("patientId"));

        Payment payment = new Payment(paymentId, price, cardholderName, cardNumber, expiryDate, cvcNumber, paymentDate, patientId);

        boolean result;
        String message = "";
        try {
            result = service.updatePayment(payment);
            if (result) {
                message = "Payment " + paymentId + " has been successfully updated!";
            } else {
                message = "Failed to update the payment! Payment ID: " + paymentId;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Search-Payment.jsp");
        rd.forward(request, response);
    }

    private void processPayment(HttpServletRequest request, HttpServletResponse response, PaymentService service) throws ServletException, IOException {
        double price = Double.parseDouble(request.getParameter("price"));
        String cardholderName = request.getParameter("cardholderName");
        int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
        String expiryDate = request.getParameter("expiryDate");
        int cvcNumber = Integer.parseInt(request.getParameter("cvcNumber"));
        String paymentDate = request.getParameter("paymentDate");
        int patientId = Integer.parseInt(request.getParameter("patientId"));

        Payment payment = new Payment(price, cardholderName, cardNumber, expiryDate, cvcNumber, paymentDate, patientId);

        boolean result;
        String message = "";
        try {
            result = service.processPayment(payment);
            if (result) {
                message = "Payment has been successfully processed!";
            } else {
                message = "Failed to process the payment!";
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Add-payment.jsp");
        rd.forward(request, response);
    }

    private void cancelPayment(HttpServletRequest request, HttpServletResponse response, PaymentService service) throws ServletException, IOException {
        int paymentId = Integer.parseInt(request.getParameter("paymentId"));

        boolean result;
        String message = "";
        try {
            result = service.cancelPayment(paymentId);
            if (result) {
                message = "Payment ID " + paymentId + " has been successfully canceled!";
            } else {
                message = "Failed to cancel the payment! Payment ID: " + paymentId;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        HttpSession session = request.getSession();

        try {
            List<Payment> paymentList = service.getAllPayments();
            session.setAttribute("paymentList", paymentList);
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        session.setAttribute("message", message);
        response.sendRedirect("PaymentDashboard.jsp");
    }
}
