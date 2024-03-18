package abc.laboratory.webapp.Dao;

import abc.laboratory.webapp.Dao.DbConnector;
import abc.laboratory.webapp.Dao.MySqlConnectorImpl;

import abc.laboratory.webapp.Dao.DbConnectorFactory;

public class MySqlDbConnectorFactoryImpl implements DbConnectorFactory{
	
	@Override
	public DbConnector getDbConnector() {
		
		return new MySqlConnectorImpl();
		
	}

}
