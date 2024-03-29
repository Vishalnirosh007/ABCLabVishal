package abc.laboratory.webapp.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abc.laboratory.webapp.Model.Payment;

public class PaymentManager {

    public DbConnector getDbConnector() {
        DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
        return factory.getDbConnector();
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        DbConnector connector = getDbConnector();
        return connector.getDbConnection();
    }

    public boolean addPayment(Payment payment) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "INSERT INTO payment (Price, Cardholdername, CardNumber, ExpiryDate, CVCnumber, Paymentdate, PatientID) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setDouble(1, payment.getPrice());
        ps.setString(2, payment.getCardholderName());
        ps.setInt(3, payment.getCardNumber());
        ps.setString(4, payment.getExpiryDate());
        ps.setInt(5, payment.getCvcNumber());
        ps.setString(6, payment.getPaymentDate());
        ps.setInt(7, payment.getPatientId());

        int result = ps.executeUpdate();

        ps.close();
        connection.close();
        return result > 0;
    }

    public Payment getSpecificPayment(int paymentId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        String query = "SELECT * FROM payment WHERE PaymentId = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, paymentId);

        ResultSet rs = ps.executeQuery();
        Payment payment = new Payment();

        while (rs.next()) {
            payment.setPaymentId(rs.getInt("PaymentId"));
            payment.setPrice(rs.getDouble("Price"));
            payment.setCardholderName(rs.getString("Cardholdername"));
            payment.setCardNumber(rs.getInt("CardNumber"));
            payment.setExpiryDate(rs.getString("ExpiryDate"));
            payment.setCvcNumber(rs.getInt("CVCnumber"));
            payment.setPaymentDate(rs.getString("Paymentdate"));
            payment.setPatientId(rs.getInt("PatientID"));
        }

        ps.close();
        connection.close();
        return payment;
    }

    public List<Payment> getAllPayments() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        List<Payment> paymentList = new ArrayList<>();

        String query = "SELECT * FROM payment";

        Statement st = connection.createStatement();

        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            Payment payment = new Payment();
            payment.setPaymentId(rs.getInt("PaymentId"));
            payment.setPrice(rs.getDouble("Price"));
            payment.setCardholderName(rs.getString("Cardholdername"));
            payment.setCardNumber(rs.getInt("CardNumber"));
            payment.setExpiryDate(rs.getString("ExpiryDate"));
            payment.setCvcNumber(rs.getInt("CVCnumber"));
            payment.setPaymentDate(rs.getString("Paymentdate"));
            payment.setPatientId(rs.getInt("PatientID"));

            paymentList.add(payment);
        }

        st.close();
        connection.close();

        return paymentList;
    }

    public boolean updatePayment(Payment payment) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "UPDATE payment SET Price = ?, Cardholdername = ?, CardNumber = ?, ExpiryDate = ?, CVCnumber = ?, Paymentdate = ?, PatientID = ? WHERE PaymentId = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setDouble(1, payment.getPrice());
        ps.setString(2, payment.getCardholderName());
        ps.setInt(3, payment.getCardNumber());
        ps.setString(4, payment.getExpiryDate());
        ps.setInt(5, payment.getCvcNumber());
        ps.setString(6, payment.getPaymentDate());
        ps.setInt(7, payment.getPatientId());
        ps.setInt(8, payment.getPaymentId());

        int result = ps.executeUpdate();

        ps.close();
        connection.close();
        return result > 0;
    }

    public boolean deletePayment(int paymentId) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "DELETE FROM payment WHERE PaymentId = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, paymentId);
        int result = ps.executeUpdate();

        ps.close();
        connection.close();
        return result > 0;
    }
}

