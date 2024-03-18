package abc.laboratory.webapp.Service;

import abc.laboratory.webapp.Dao.DoctorManager;
import abc.laboratory.webapp.Model.Doctor;

import java.sql.SQLException;
import java.util.List;

public class DoctorService {

    private static DoctorService doctorServiceObj;

    private DoctorService() {

    }

    public static synchronized DoctorService getDoctorServiceInstance() {

        if (doctorServiceObj == null) {
            doctorServiceObj = new DoctorService();
        }

        return doctorServiceObj;
    }

    private DoctorManager getDoctorManager() {
        return new DoctorManager();
    }

    public boolean registerDoctor(Doctor doctor) throws ClassNotFoundException, SQLException {
        return getDoctorManager().addDoctor(doctor);
    }

    public Doctor getSpecificDoctor(int doctorID) throws ClassNotFoundException, SQLException {
        return getDoctorManager().getSpecificDoctor(doctorID);
    }

    public List<Doctor> getAllDoctors() throws ClassNotFoundException, SQLException {
        return getDoctorManager().getAllDoctors();
    }

    public boolean editTheDoctor(Doctor doctor) throws ClassNotFoundException, SQLException {
        return getDoctorManager().updateDoctor(doctor);
    }

    public boolean deleteTheDoctor(int doctorID) throws ClassNotFoundException, SQLException {
        return getDoctorManager().deleteDoctor(doctorID);
    }
}