package abc.laboratory.webapp.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LabWorkerTest {

    @Test
    void testGettersAndSetters() {
        LabWorker labWorker = new LabWorker();
        
        labWorker.setLabWorkerID(1);
        assertEquals(1, labWorker.getLabWorkerID());
        
        labWorker.setLabWorkerName("Vishal Nirosh");
        assertEquals("Vishal Nirosh", labWorker.getLabWorkerName());
        
        labWorker.setDescription("Laboratory technician");
        assertEquals("Laboratory technician", labWorker.getDescription());
    }
    
    @Test
    void testConstructors() {
        LabWorker labWorker = new LabWorker(1, "Vishal Nirosh", "Laboratory technician");
        
        assertEquals(1, labWorker.getLabWorkerID());
        assertEquals("Vishal Nirosh", labWorker.getLabWorkerName());
        assertEquals("Laboratory technician", labWorker.getDescription());
    }
}
