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
        
        appointment.setLabWorkerName("John Doe");
        assertEquals("John Doe", appointment.getLabWorkerName());
        
        appointment.setPatientID(123);
        assertEquals(123, appointment.getPatientID());
        
        appointment.setCheckupID(456);
        assertEquals(456, appointment.getCheckupID());
        
        appointment.setDoctorID(789);
        assertEquals(789, appointment.getDoctorID());
        
        appointment.setLabWorkerID(101);
        assertEquals(101, appointment.getLabWorkerID());
        
        appointment.setAppointmentStatus("Scheduled");
        assertEquals("Scheduled", appointment.getAppointmentStatus());
    }
    
    @Test
    void testConstructors() {
        Appointment appointment = new Appointment(1, "2024-03-25", "Dr. Smith", "Blood Test", "John Doe", 123, 456, 789, 101, "Scheduled");
        
        assertEquals(1, appointment.getAppointmentID());
        assertEquals("2024-03-25", appointment.getAppointmentDate());
        assertEquals("Dr. Smith", appointment.getDoctorName());
        assertEquals("Blood Test", appointment.getCheckupName());
        assertEquals("John Doe", appointment.getLabWorkerName());
        assertEquals(123, appointment.getPatientID());
        assertEquals(456, appointment.getCheckupID());
        assertEquals(789, appointment.getDoctorID());
        assertEquals(101, appointment.getLabWorkerID());
        assertEquals("Scheduled", appointment.getAppointmentStatus());
    }
}
