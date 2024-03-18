package abc.laboratory.webapp.Service;


import java.sql.SQLException;
import java.util.List;

import abc.laboratory.webapp.Dao.LabWorkerManager;
import abc.laboratory.webapp.Model.LabWorker;

public class LabWorkerService {

    private static LabWorkerService labWorkerServiceObj;

    private LabWorkerService() {

    }

    public static synchronized LabWorkerService getLabWorkerServiceInstance() {

        if (labWorkerServiceObj == null) {
            labWorkerServiceObj = new LabWorkerService();
        }

        return labWorkerServiceObj;
    }

    private LabWorkerManager getLabWorkerManager() {
        return new LabWorkerManager();
    }

    public boolean registerLabWorker(LabWorker labWorker) throws ClassNotFoundException, SQLException {
        return getLabWorkerManager().addLabWorker(labWorker);
    }

    public LabWorker getSpecificLabWorker(int labWorkerID) throws ClassNotFoundException, SQLException {
        return getLabWorkerManager().getSpecificLabWorker(labWorkerID);
    }

    public List<LabWorker> getAllLabWorkers() throws ClassNotFoundException, SQLException {
        return getLabWorkerManager().getAllLabWorkers();
    }

    public boolean editTheLabWorker(LabWorker labWorker) throws ClassNotFoundException, SQLException {
        return getLabWorkerManager().updateLabWorker(labWorker);
    }

    public boolean deleteTheLabWorker(int labWorkerID) throws ClassNotFoundException, SQLException {
        return getLabWorkerManager().deleteLabWorker(labWorkerID);
    }
}
