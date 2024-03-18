package abc.laboratory.webapp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abc.laboratory.webapp.Model.TestDetail;

public class TestDetailManager {
	

    public DbConnector getDbConnector() {
        DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl(); 
        return factory.getDbConnector();
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException{
        DbConnector connector = getDbConnector();
        return connector.getDbConnection();
    }

    public boolean addTestDetail(TestDetail testDetail) throws ClassNotFoundException, SQLException  {
        Connection connection = getConnection(); 
        String query = "INSERT INTO testdetail (AppointmentID, TechnicianName, DoctorName) VALUES (?, ?, ?)";
        
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, testDetail.getAppointmentID());
        ps.setString(2, testDetail.getTechnicianName());
        ps.setString(3, testDetail.getDoctorName());
        
        int result = ps.executeUpdate();
        
        ps.close();
        connection.close();        
        return result > 0;
    }

   

    public List<TestDetail> getAllTestDetails() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();    
        List<TestDetail> testDetailList = new ArrayList<>();
        
        String query = "SELECT * FROM testdetail";
        
        Statement st = connection.createStatement();
        
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()) {
            TestDetail testDetail = new TestDetail();
            testDetail.setIdTestDetail(rs.getInt("Idtestdetail"));
            testDetail.setAppointmentID(rs.getInt("AppointmentID"));
            testDetail.setTechnicianName(rs.getString("TechnicianName"));
            testDetail.setDoctorName(rs.getString("DoctorName"));
            
            testDetailList.add(testDetail);
        }
        
        st.close();
        connection.close();
        
        return testDetailList;        
    }


    public boolean deleteTestDetail(int idTestDetail) throws ClassNotFoundException, SQLException  {
        Connection connection = getConnection();        
        String query = "DELETE FROM testdetail WHERE Idtestdetail = ?";
        
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, idTestDetail);
        int result = ps.executeUpdate();
        
        ps.close();
        connection.close();        
        return result > 0;
    }

}
