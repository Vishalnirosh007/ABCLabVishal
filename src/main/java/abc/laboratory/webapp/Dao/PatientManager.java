package abc.laboratory.webapp.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abc.laboratory.webapp.Model.Patient;

public class PatientManager {

    public DbConnector getDbConnector() {
        DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
        return factory.getDbConnector();
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        DbConnector connector = getDbConnector();
        return connector.getDbConnection();
    }

    public boolean addPatient(Patient patient) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "INSERT INTO patient (PatientFullName, PatientPhoneNumber, DateOfBirth, PatientAddress, Gender, PatientEmail, PatientUsername, PatientPassword) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, patient.getPatientFullName());
        ps.setInt(2, patient.getPatientPhoneNumber());
        ps.setString(3, patient.getDateOfBirth());
        ps.setString(4, patient.getPatientAddress());
        ps.setString(5, patient.getGender());
        ps.setString(6, patient.getPatientEmail());
        ps.setString(7, patient.getPatientUsername());
        ps.setString(8, patient.getPatientPassword());

        int result = ps.executeUpdate();

        ps.close();
        connection.close();
        return result > 0;
    }

    public Patient getSpecificPatient(int patientID) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        String query = "SELECT * FROM patient WHERE PatientID = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, patientID);

        ResultSet rs = ps.executeQuery();
        Patient patient = new Patient();

        while (rs.next()) {
            patient.setPatientID(rs.getInt("PatientID"));
            patient.setPatientFullName(rs.getString("PatientFullName"));
            patient.setPatientPhoneNumber(rs.getInt("PatientPhoneNumber"));
            patient.setDateOfBirth(rs.getString("DateOfBirth"));
            patient.setPatientAddress(rs.getString("PatientAddress"));
            patient.setGender(rs.getString("Gender"));
            patient.setPatientEmail(rs.getString("PatientEmail"));
            patient.setPatientUsername(rs.getString("PatientUsername"));
            patient.setPatientPassword(rs.getString("PatientPassword"));
        }

        ps.close();
        connection.close();
        return patient;
    }

    public List<Patient> getAllPatients() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        List<Patient> patientList = new ArrayList<>();

        String query = "SELECT * FROM patient";

        Statement st = connection.createStatement();

        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            Patient patient = new Patient();
            patient.setPatientID(rs.getInt("PatientID"));
            patient.setPatientFullName(rs.getString("PatientFullName"));
            patient.setPatientPhoneNumber(rs.getInt("PatientPhoneNumber"));
            patient.setDateOfBirth(rs.getString("DateOfBirth"));
            patient.setPatientAddress(rs.getString("PatientAddress"));
            patient.setGender(rs.getString("Gender"));
            patient.setPatientEmail(rs.getString("PatientEmail"));
            patient.setPatientUsername(rs.getString("PatientUsername"));
            patient.setPatientPassword(rs.getString("PatientPassword"));

            patientList.add(patient);
        }

        st.close();
        connection.close();

        return patientList;
    }

    public boolean updatePatient(Patient patient) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "UPDATE patient SET PatientFullName = ?, PatientPhoneNumber = ?, DateOfBirth = ?, " +
                "PatientAddress = ?, Gender = ?, PatientEmail = ?, PatientUsername = ?, PatientPassword = ? " +
                "WHERE PatientID = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, patient.getPatientFullName());
        ps.setInt(2, patient.getPatientPhoneNumber());
        ps.setString(3, patient.getDateOfBirth());
        ps.setString(4, patient.getPatientAddress());
        ps.setString(5, patient.getGender());
        ps.setString(6, patient.getPatientEmail());
        ps.setString(7, patient.getPatientUsername());
        ps.setString(8, patient.getPatientPassword());
        ps.setInt(9, patient.getPatientID());

        int result = ps.executeUpdate();

        ps.close();
        connection.close();
        return result > 0;
    }

    public boolean deletePatient(int patientID) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "DELETE FROM patient WHERE PatientID = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, patientID);

        int result = ps.executeUpdate();

        ps.close();
        connection.close();
        return result > 0;
    }
    public boolean validatePatientCredentials(String username, String password) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "SELECT * FROM patient WHERE PatientUsername = ? AND PatientPassword = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        boolean isValid = rs.next(); // If result set has next, it means credentials are valid
        ps.close();
        connection.close();
        return isValid;
    }
}
