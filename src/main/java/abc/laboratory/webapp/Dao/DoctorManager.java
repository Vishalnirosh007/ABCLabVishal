package abc.laboratory.webapp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abc.laboratory.webapp.Model.Doctor;

public class DoctorManager {

    public DbConnector getDbConnector() {
        DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
        return factory.getDbConnector();
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        DbConnector connector = getDbConnector();
        return connector.getDbConnection();
    }

    public boolean addDoctor(Doctor doctor) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "INSERT INTO doctor (DoctorFirstName, DoctorLastName, DoctorSpecialization, DoctorEmail) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, doctor.getFirstName());
        ps.setString(2, doctor.getLastName());
        ps.setString(3, doctor.getSpecialization());
        ps.setString(4, doctor.getEmail());

        int result = ps.executeUpdate();

        ps.close();
        connection.close();
        return result > 0;
    }

    public Doctor getSpecificDoctor(int doctorID) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        String query = "SELECT * FROM doctor WHERE DoctorID = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, doctorID);

        ResultSet rs = ps.executeQuery();
        Doctor doctor = new Doctor();

        while (rs.next()) {
            doctor.setDoctorID(rs.getInt("DoctorID"));
            doctor.setFirstName(rs.getString("DoctorFirstName"));
            doctor.setLastName(rs.getString("DoctorLastName"));
            doctor.setSpecialization(rs.getString("DoctorSpecialization"));
            doctor.setEmail(rs.getString("DoctorEmail"));
        }

        ps.close();
        connection.close();
        return doctor;
    }

    public List<Doctor> getAllDoctors() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        List<Doctor> doctorList = new ArrayList<>();

        String query = "SELECT * FROM doctor";

        Statement st = connection.createStatement();

        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            Doctor doctor = new Doctor();
            doctor.setDoctorID(rs.getInt("DoctorID"));
            doctor.setFirstName(rs.getString("DoctorFirstName"));
            doctor.setLastName(rs.getString("DoctorLastName"));
            doctor.setSpecialization(rs.getString("DoctorSpecialization"));
            doctor.setEmail(rs.getString("DoctorEmail"));

            doctorList.add(doctor);
        }

        st.close();
        connection.close();

        return doctorList;
    }

    public boolean updateDoctor(Doctor doctor) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "UPDATE doctor SET DoctorFirstName = ?, DoctorLastName = ?, DoctorSpecialization = ?, DoctorEmail = ? WHERE DoctorID = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, doctor.getFirstName());
        ps.setString(2, doctor.getLastName());
        ps.setString(3, doctor.getSpecialization());
        ps.setString(4, doctor.getEmail());
        ps.setInt(5, doctor.getDoctorID());

        int result = ps.executeUpdate();

        ps.close();
        connection.close();
        return result > 0;
    }

    public boolean deleteDoctor(int doctorID) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "DELETE FROM doctor WHERE DoctorID = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, doctorID);
        int result = ps.executeUpdate();

        ps.close();
        connection.close();
        return result > 0;
    }
}