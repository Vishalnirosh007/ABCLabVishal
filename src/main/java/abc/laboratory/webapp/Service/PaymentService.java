package abc.laboratory.webapp.Service;


import abc.laboratory.webapp.Dao.PaymentManager;
import abc.laboratory.webapp.Model.Payment;

import java.sql.SQLException;
import java.util.List;

public class PaymentService {

    private static PaymentService paymentServiceInstance;

    private PaymentService() {

    }

    public static synchronized PaymentService getPaymentServiceInstance() {
        if (paymentServiceInstance == null) {
            paymentServiceInstance = new PaymentService();
        }
        return paymentServiceInstance;
    }

    private PaymentManager getPaymentManager() {
        return new PaymentManager();
    }

    public boolean processPayment(Payment payment) throws ClassNotFoundException, SQLException {
        return getPaymentManager().addPayment(payment);
    }

    public Payment getSpecificPayment(int paymentId) throws ClassNotFoundException, SQLException {
        return getPaymentManager().getSpecificPayment(paymentId);
    }

    public List<Payment> getAllPayments() throws ClassNotFoundException, SQLException {
        return getPaymentManager().getAllPayments();
    }

    public boolean updatePayment(Payment payment) throws ClassNotFoundException, SQLException {
        return getPaymentManager().updatePayment(payment);
    }

    public boolean cancelPayment(int paymentId) throws ClassNotFoundException, SQLException {
        return getPaymentManager().deletePayment(paymentId);
    }
}

