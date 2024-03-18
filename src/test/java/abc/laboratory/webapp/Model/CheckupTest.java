package abc.laboratory.webapp.Model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckupTest {

    @Test
    void testGettersAndSetters() {
        Checkup checkup = new Checkup();
        
        checkup.setCheckupID(1);
        assertEquals(1, checkup.getCheckupID());
        
        checkup.setCheckupName("Blood Test");
        assertEquals("Blood Test", checkup.getCheckupName());
        
        checkup.setCheckupCost(50.0);
        assertEquals(50.0, checkup.getCheckupCost());
        
        checkup.setCheckupDescription("This is a blood test.");
        assertEquals("This is a blood test.", checkup.getCheckupDescription());
    }
    
    @Test
    void testConstructors() {
        Checkup checkup = new Checkup(1, "Blood Test", 50.0, "This is a blood test.");
        
        assertEquals(1, checkup.getCheckupID());
        assertEquals("Blood Test", checkup.getCheckupName());
        assertEquals(50.0, checkup.getCheckupCost());
        assertEquals("This is a blood test.", checkup.getCheckupDescription());
    }
}
