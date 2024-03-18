package abc.laboratory.webapp.Service;

import java.sql.SQLException;


import abc.laboratory.webapp.Dao.RegisterPatientMnager;
import abc.laboratory.webapp.Model.Patient;

public class RegisterPatientService {
	
	private static RegisterPatientService registerpatientServiceObj;

    private RegisterPatientService() {

    }

    public static synchronized RegisterPatientService getRegisterpatientServiceInstance() {

        if (registerpatientServiceObj == null) {
        	registerpatientServiceObj = new RegisterPatientService();
        }

        return registerpatientServiceObj;
    }
    private RegisterPatientMnager getRegisterPatientMnager() {
        return new RegisterPatientMnager();
    }
    
    public boolean registerPatient(Patient patient) throws ClassNotFoundException, SQLException {
        return getRegisterPatientMnager().addPatient(patient);
    }

}
