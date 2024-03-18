package abc.laboratory.webapp.Service;

import java.sql.SQLException;
import java.util.List;

import abc.laboratory.webapp.Dao.TestDetailManager;
import abc.laboratory.webapp.Model.TestDetail;

public class TestDetailService {

	
	private static TestDetailService testDetailServiceObj;

    private TestDetailService() {

    }

    public static synchronized TestDetailService getTestDetailServiceInstance() {

        if (testDetailServiceObj == null) {
            testDetailServiceObj = new TestDetailService();
        }

        return testDetailServiceObj;
    }

    private TestDetailManager getTestDetailManager() {
        return new TestDetailManager();
    }

    public boolean registerTestDetail(TestDetail testDetail) throws ClassNotFoundException, SQLException {
        return getTestDetailManager().addTestDetail(testDetail);
    }

    

    public List<TestDetail> getAllTestDetails() throws ClassNotFoundException, SQLException {
        return getTestDetailManager().getAllTestDetails();
    }

   
    public boolean deleteTheTestDetail(int idTestDetail) throws ClassNotFoundException, SQLException {
        return getTestDetailManager().deleteTestDetail(idTestDetail);
    }
}
