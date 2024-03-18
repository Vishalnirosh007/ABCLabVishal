package abc.laboratory.webapp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abc.laboratory.webapp.Model.Checkup;

public class CheckupManager {

    public DbConnector getDbConnector() {
        DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
        return factory.getDbConnector();
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        DbConnector connector = getDbConnector();
        return connector.getDbConnection();
    }

    public boolean addCheckup(Checkup checkup) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "INSERT INTO checkup (CheckupName, CheckupCost, CheckupDescription) VALUES (?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, checkup.getCheckupName());
        ps.setDouble(2, checkup.getCheckupCost());
        ps.setString(3, checkup.getCheckupDescription());

        int result = ps.executeUpdate();

        ps.close();
        connection.close();
        return result > 0;
    }

    public Checkup getSpecificCheckup(int checkupID) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        String query = "SELECT * FROM checkup WHERE CheckupID = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, checkupID);

        ResultSet rs = ps.executeQuery();
        Checkup checkup = new Checkup();

        while (rs.next()) {
            checkup.setCheckupID(rs.getInt("CheckupID"));
            checkup.setCheckupName(rs.getString("CheckupName"));
            checkup.setCheckupCost(rs.getDouble("CheckupCost"));
            checkup.setCheckupDescription(rs.getString("CheckupDescription"));
        }

        ps.close();
        connection.close();
        return checkup;
    }

    public List<Checkup> getAllCheckups() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        List<Checkup> checkupList = new ArrayList<>();

        String query = "SELECT * FROM checkup";

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            Checkup checkup = new Checkup();
            checkup.setCheckupID(rs.getInt("CheckupID"));
            checkup.setCheckupName(rs.getString("CheckupName"));
            checkup.setCheckupCost(rs.getDouble("CheckupCost"));
            checkup.setCheckupDescription(rs.getString("CheckupDescription"));
            checkupList.add(checkup);
        }

        st.close();
        connection.close();

        return checkupList;
    }

    public boolean updateCheckup(Checkup checkup) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "UPDATE checkup SET CheckupName = ?, CheckupCost = ?, CheckupDescription = ? WHERE CheckupID = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, checkup.getCheckupName());
        ps.setDouble(2, checkup.getCheckupCost());
        ps.setString(3, checkup.getCheckupDescription());
        ps.setInt(4, checkup.getCheckupID());

        int result = ps.executeUpdate();

        ps.close();
        connection.close();
        return result > 0;
    }

    public boolean deleteCheckup(int checkupID) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "DELETE FROM checkup WHERE CheckupID = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, checkupID);

        int result = ps.executeUpdate();

        ps.close();
        connection.close();
        return result > 0;
    }
}