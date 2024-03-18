package abc.laboratory.webapp.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PatientTest {

    @Test
    void testGettersAndSetters() {
        Patient patient = new Patient();
        
        patient.setPatientID(1);
        assertEquals(1, patient.getPatientID());
        
        patient.setPatientFullName("John Doe");
        assertEquals("John Doe", patient.getPatientFullName());
        
        patient.setPatientPhoneNumber(1234567890);
        assertEquals(1234567890, patient.getPatientPhoneNumber());
        
        patient.setDateOfBirth("2000-01-01");
        assertEquals("2000-01-01", patient.getDateOfBirth());
        
        patient.setPatientAddress("123 Main St");
        assertEquals("123 Main St", patient.getPatientAddress());
        
        patient.setGender("Male");
        assertEquals("Male", patient.getGender());
        
        patient.setPatientEmail("john@example.com");
        assertEquals("john@example.com", patient.getPatientEmail());
        
        patient.setPatientUsername("john123");
        assertEquals("john123", patient.getPatientUsername());
        
        patient.setPatientPassword("password");
        assertEquals("password", patient.getPatientPassword());
    }
    
    @Test
    void testConstructors() {
        Patient patient = new Patient("John Doe", 1234567890, "2000-01-01", "123 Main St",
                                      "Male", "john@example.com", "john123", "password");
        
        assertEquals("John Doe", patient.getPatientFullName());
        assertEquals(1234567890, patient.getPatientPhoneNumber());
        assertEquals("2000-01-01", patient.getDateOfBirth());
        assertEquals("123 Main St", patient.getPatientAddress());
        assertEquals("Male", patient.getGender());
        assertEquals("john@example.com", patient.getPatientEmail());
        assertEquals("john123", patient.getPatientUsername());
        assertEquals("password", patient.getPatientPassword());
    }
}
