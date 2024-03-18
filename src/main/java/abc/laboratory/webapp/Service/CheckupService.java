package abc.laboratory.webapp.Service;

import java.sql.SQLException;
import java.util.List;

import abc.laboratory.webapp.Dao.CheckupManager;
import abc.laboratory.webapp.Model.Checkup;



public class CheckupService {

    private static CheckupService checkupServiceObj;

    private CheckupService() {

    }

    public static synchronized CheckupService getCheckupServiceInstance() {

        if (checkupServiceObj == null) {
            checkupServiceObj = new CheckupService();
        }

        return checkupServiceObj;
    }

    private CheckupManager getCheckupManager() {
        return new CheckupManager();
    }

    public boolean registerCheckup(Checkup checkup) throws ClassNotFoundException, SQLException {
        return getCheckupManager().addCheckup(checkup);
    }

    public Checkup getSpecificCheckup(int checkupID) throws ClassNotFoundException, SQLException {
        return getCheckupManager().getSpecificCheckup(checkupID);
    }

    public List<Checkup> getAllCheckups() throws ClassNotFoundException, SQLException {
        return getCheckupManager().getAllCheckups();
    }

    public boolean editTheCheckup(Checkup checkup) throws ClassNotFoundException, SQLException {
        return getCheckupManager().updateCheckup(checkup);
    }

    public boolean deleteTheCheckup(int checkupID) throws ClassNotFoundException, SQLException {
        return getCheckupManager().deleteCheckup(checkupID);
    }
}