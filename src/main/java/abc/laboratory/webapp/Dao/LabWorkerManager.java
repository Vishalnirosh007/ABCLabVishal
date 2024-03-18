package abc.laboratory.webapp.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abc.laboratory.webapp.Model.LabWorker;

public class LabWorkerManager {

    public DbConnector getDbConnector() {
        DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl(); 
        return factory.getDbConnector();
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        DbConnector connector = getDbConnector();
        return connector.getDbConnection();
    }

    public boolean addLabWorker(LabWorker labWorker) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection(); 
        String query = "INSERT INTO labworker (LabWorkerName, Description) VALUES (?, ?)";
        
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, labWorker.getLabWorkerName());
        ps.setString(2, labWorker.getDescription());
        
        int result = ps.executeUpdate();
        
        ps.close();
        connection.close();        
        return result > 0;
    }

    public LabWorker getSpecificLabWorker(int labWorkerID) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        String query = "SELECT * FROM labworker WHERE LabworkerID = ?";
        
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, labWorkerID);
        
        ResultSet rs = ps.executeQuery();
        LabWorker labWorker = new LabWorker();
        
        while(rs.next()) {
            labWorker.setLabWorkerID(rs.getInt("LabworkerID"));
            labWorker.setLabWorkerName(rs.getString("LabWorkerName"));
            labWorker.setDescription(rs.getString("Description"));
        }
        
        ps.close();
        connection.close();        
        return labWorker;
    }

    public List<LabWorker> getAllLabWorkers() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection(); 
        List<LabWorker> labWorkerList = new ArrayList<>();
        
        String query = "SELECT * FROM labworker";
        
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()) {
            LabWorker labWorker = new LabWorker();
            labWorker.setLabWorkerID(rs.getInt("LabworkerID"));
            labWorker.setLabWorkerName(rs.getString("LabWorkerName"));
            labWorker.setDescription(rs.getString("Description"));
            labWorkerList.add(labWorker);
        }
        
        st.close();
        connection.close();
        
        return labWorkerList;       
    }

    public boolean updateLabWorker(LabWorker labWorker) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "UPDATE labworker SET LabWorkerName = ?, Description = ? WHERE LabworkerID = ?";
        
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, labWorker.getLabWorkerName());
        ps.setString(2, labWorker.getDescription());
        ps.setInt(3, labWorker.getLabWorkerID());
        
        int result = ps.executeUpdate();
        
        ps.close();
        connection.close();
        return result > 0;
    }

    public boolean deleteLabWorker(int labWorkerID) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();        
        String query = "DELETE FROM labworker WHERE LabworkerID = ?";
        
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, labWorkerID);
        int result = ps.executeUpdate();
        
        ps.close();
        connection.close();        
        return result > 0;
    }
}

