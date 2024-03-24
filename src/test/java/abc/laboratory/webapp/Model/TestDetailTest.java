package abc.laboratory.webapp.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDetailTest {

    @Test
    void testGettersAndSetters() {
        TestDetail testDetail = new TestDetail();
        
        testDetail.setIdTestDetail(1);
        assertEquals(1, testDetail.getIdTestDetail());
        
        testDetail.setAppointmentID(2);
        assertEquals(2, testDetail.getAppointmentID());
        
        testDetail.setTechnicianName("Vishal Nirosh");
        assertEquals("Vishal Nirosh", testDetail.getTechnicianName());
        
        testDetail.setDoctorName("Dr. Smith");
        assertEquals("Dr. Smith", testDetail.getDoctorName());
    }
    
    @Test
    void testConstructors() {
        TestDetail testDetail = new TestDetail(1, 2, "Vishal Nirosh", "Dr. Smith");
        
        assertEquals(1, testDetail.getIdTestDetail());
        assertEquals(2, testDetail.getAppointmentID());
        assertEquals("Vishal Nirosh", testDetail.getTechnicianName());
        assertEquals("Dr. Smith", testDetail.getDoctorName());
    }
}
