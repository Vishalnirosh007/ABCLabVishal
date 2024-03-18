package abc.laboratory.webapp.Dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnector {

	Connection getDbConnection() throws SQLException, ClassNotFoundException;
}
