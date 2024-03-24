package abc.laboratory.webapp.Model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AppointmentTest {

    @Test
    void testGettersAndSetters() {
        Appointment appointment = new Appointment();

        appointment.setAppointmentID(1);
        assertEquals(1, appointment.getAppointmentID());

        appointment.setAppointmentDate("2024-03-25");
        assertEquals("2024-03-25", appointment.getAppointmentDate());

        appointment.setDoctorName("Dr. Smith");
        assertEquals("Dr. Smith", appointment.getDoctorName());

        appointment.setCheckupName("Blood Test");
        assertEquals("Blood Test", appointment.getCheckupName());

        appointment.setPatientID(123);
        assertEquals(123, appointment.getPatientID());

        appointment.setAppointmentStatus("Scheduled");
        assertEquals("Scheduled", appointment.getAppointmentStatus());
    }

    @Test
    void testConstructors() {
        Appointment appointment = new Appointment(1, 123, "2024-03-25", "Blood Test", "Dr. Smith", "Scheduled");

        assertEquals(1, appointment.getAppointmentID());
        assertEquals(123, appointment.getPatientID());
        assertEquals("2024-03-25", appointment.getAppointmentDate());
        assertEquals("Blood Test", appointment.getCheckupName());
        assertEquals("Dr. Smith", appointment.getDoctorName());
        assertEquals("Scheduled", appointment.getAppointmentStatus());
    }
}
