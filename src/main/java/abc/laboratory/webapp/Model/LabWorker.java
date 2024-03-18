package abc.laboratory.webapp.Model;


public class LabWorker {
    private int labWorkerID;
    private String labWorkerName;
    private String description;
    
   

    public LabWorker(int labWorkerID,String labWorkerName, String description) {
    	this.labWorkerID = labWorkerID;
    	this.labWorkerName = labWorkerName;
        this.description = description;
    }
    public LabWorker(String labWorkerName, String description) {
        this.labWorkerName = labWorkerName;
        this.description = description;
    }
 
    public LabWorker() {
        
    }
    public int getLabWorkerID() {
        return labWorkerID;
    }

    public void setLabWorkerID(int labWorkerID) {
        this.labWorkerID = labWorkerID;
    }

    public String getLabWorkerName() {
        return labWorkerName;
    }

    public void setLabWorkerName(String labWorkerName) {
        this.labWorkerName = labWorkerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
