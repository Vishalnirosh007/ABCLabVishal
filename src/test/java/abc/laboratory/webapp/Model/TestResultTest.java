package abc.laboratory.webapp.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestResultTest {

    @Test
    void testGettersAndSetters() {
        TestResult testResult = new TestResult();
        
        testResult.setResultID(1);
        assertEquals(1, testResult.getResultID());
        
        testResult.setAppointmentID(2);
        assertEquals(2, testResult.getAppointmentID());
        
        testResult.setResult("Positive");
        assertEquals("Positive", testResult.getResult());
        
        byte[] report = {0x01, 0x02, 0x03}; // Sample byte array
        testResult.setReport(report);
        assertArrayEquals(report, testResult.getReport());
    }
    
    @Test
    void testConstructors() {
        byte[] report = {0x01, 0x02, 0x03}; // Sample byte array
        
        TestResult testResultWithID = new TestResult(1, 2, "Positive", report);
        assertEquals(1, testResultWithID.getResultID());
        assertEquals(2, testResultWithID.getAppointmentID());
        assertEquals("Positive", testResultWithID.getResult());
        assertArrayEquals(report, testResultWithID.getReport());
        
        TestResult testResultWithoutID = new TestResult(2, "Negative", report);
        assertEquals(2, testResultWithoutID.getAppointmentID());
        assertEquals("Negative", testResultWithoutID.getResult());
        assertArrayEquals(report, testResultWithoutID.getReport());
    }
}
