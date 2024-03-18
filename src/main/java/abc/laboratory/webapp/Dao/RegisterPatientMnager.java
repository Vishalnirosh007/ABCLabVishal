package abc.laboratory.webapp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import abc.laboratory.webapp.Model.Patient;

public class RegisterPatientMnager {
	
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
    

}
