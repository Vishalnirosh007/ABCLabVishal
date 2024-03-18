package abc.laboratory.webapp.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoctorTest {

    @Test
    void testGettersAndSetters() {
        Doctor doctor = new Doctor();
        
        doctor.setDoctorID(1);
        assertEquals(1, doctor.getDoctorID());
        
        doctor.setFirstName("John");
        assertEquals("John", doctor.getFirstName());
        
        doctor.setLastName("Doe");
        assertEquals("Doe", doctor.getLastName());
        
        doctor.setSpecialization("Cardiology");
        assertEquals("Cardiology", doctor.getSpecialization());
        
        doctor.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", doctor.getEmail());
    }
    
    @Test
    void testConstructors() {
        Doctor doctor = new Doctor(1, "John", "Doe", "Cardiology", "john.doe@example.com");
        
        assertEquals(1, doctor.getDoctorID());
        assertEquals("John", doctor.getFirstName());
        assertEquals("Doe", doctor.getLastName());
        assertEquals("Cardiology", doctor.getSpecialization());
        assertEquals("john.doe@example.com", doctor.getEmail());
    }
}
