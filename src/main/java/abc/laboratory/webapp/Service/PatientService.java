package abc.laboratory.webapp.Service;


import abc.laboratory.webapp.Dao.PatientManager;
import abc.laboratory.webapp.Model.Patient;

import java.sql.SQLException;
import java.util.List;

public class PatientService {

    private static PatientService patientServiceObj;

    private PatientService() {

    }

    public static synchronized PatientService getPatientServiceInstance() {

        if (patientServiceObj == null) {
            patientServiceObj = new PatientService();
        }

        return patientServiceObj;
    }

    private PatientManager getPatientManager() {
        return new PatientManager();
    }

    public boolean registerPatient(Patient patient) throws ClassNotFoundException, SQLException {
        return getPatientManager().addPatient(patient);
    }

    public Patient getSpecificPatient(int patientID) throws ClassNotFoundException, SQLException {
        return getPatientManager().getSpecificPatient(patientID);
    }

    public List<Patient> getAllPatients() throws ClassNotFoundException, SQLException {
        return getPatientManager().getAllPatients();
    }

    public boolean editThePatient(Patient patient) throws ClassNotFoundException, SQLException {
        return getPatientManager().updatePatient(patient);
    }

    public boolean deleteThePatient(int patientID) throws ClassNotFoundException, SQLException {
        return getPatientManager().deletePatient(patientID);
    }
    public boolean validatePatientCredentials(String username, String password) throws ClassNotFoundException, SQLException {
        // Assuming you have a method in your DAO to validate credentials
        return getPatientManager().validatePatientCredentials(username, password);
    }
}
