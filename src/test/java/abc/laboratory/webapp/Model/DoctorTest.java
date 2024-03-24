package abc.laboratory.webapp.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoctorTest {

    @Test
    void testGettersAndSetters() {
        Doctor doctor = new Doctor();
        
        doctor.setDoctorID(1);
        assertEquals(1, doctor.getDoctorID());
        
        doctor.setFirstName("Vishal");
        assertEquals("Vishal", doctor.getFirstName());
        
        doctor.setLastName("Nirosh");
        assertEquals("Nirosh", doctor.getLastName());
        
        doctor.setSpecialization("Cardiology");
        assertEquals("Cardiology", doctor.getSpecialization());
        
        doctor.setEmail("Vishal.Nirosh@example.com");
        assertEquals("Vishal.Nirosh@example.com", doctor.getEmail());
    }
    
    @Test
    void testConstructors() {
        Doctor doctor = new Doctor(1, "Vishal", "Nirosh", "Cardiology", "Vishal.Nirosh@example.com");
        
        assertEquals(1, doctor.getDoctorID());
        assertEquals("Vishal", doctor.getFirstName());
        assertEquals("Nirosh", doctor.getLastName());
        assertEquals("Cardiology", doctor.getSpecialization());
        assertEquals("Vishal.Nirosh@example.com", doctor.getEmail());
    }
}
