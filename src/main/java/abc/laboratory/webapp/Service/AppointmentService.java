package abc.laboratory.webapp.Service;


import abc.laboratory.webapp.Dao.AppointmentManager;
import abc.laboratory.webapp.Model.Appointment;

import java.sql.SQLException;
import java.util.List;

public class AppointmentService {

    private static AppointmentService appointmentServiceObj;

    private AppointmentService() {

    }

    public static synchronized AppointmentService getAppointmentServiceInstance() {
        if (appointmentServiceObj == null) {
            appointmentServiceObj = new AppointmentService();
        }
        return appointmentServiceObj;
    }

    private AppointmentManager getAppointmentManager() {
        return new AppointmentManager();
    }

    public boolean registerAppointment(Appointment appointment) throws ClassNotFoundException, SQLException {
        return getAppointmentManager().addAppointment(appointment);
    }

    public Appointment getSpecificAppointment(int appointmentID) throws ClassNotFoundException, SQLException {
        return getAppointmentManager().getSpecificAppointment(appointmentID);
    }

    public List<Appointment> getAllAppointments() throws ClassNotFoundException, SQLException {
        return getAppointmentManager().getAllAppointments();
    }

    public boolean editTheAppointment(Appointment appointment) throws ClassNotFoundException, SQLException {
        return getAppointmentManager().updateAppointment(appointment);
    }

    public boolean deleteTheAppointment(int appointmentID) throws ClassNotFoundException, SQLException {
        return getAppointmentManager().deleteAppointment(appointmentID);
    }
}
