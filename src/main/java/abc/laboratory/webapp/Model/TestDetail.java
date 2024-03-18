package abc.laboratory.webapp.Model;

public class TestDetail {
	
	 private int idTestDetail; // corresponds to Idtestdetail in the table
	    private int appointmentID; // corresponds to AppointmentID in the table
	    private String technicianName; // corresponds to TechnicianName in the table
	    private String doctorName; // corresponds to DoctorName in the table

	    public TestDetail(int appointmentID, String technicianName, String doctorName) {
	        this.appointmentID = appointmentID;
	        this.technicianName = technicianName;
	        this.doctorName = doctorName;
	    }

	    public TestDetail(int idTestDetail, int appointmentID, String technicianName, String doctorName) {
	        this.idTestDetail = idTestDetail;
	        this.appointmentID = appointmentID;
	        this.technicianName = technicianName;
	        this.doctorName = doctorName;
	    }

	    public TestDetail() {
	        // Default constructor
	    }

	    public int getIdTestDetail() {
	        return idTestDetail;
	    }

	    public void setIdTestDetail(int idTestDetail) {
	        this.idTestDetail = idTestDetail;
	    }

	    public int getAppointmentID() {
	        return appointmentID;
	    }

	    public void setAppointmentID(int appointmentID) {
	        this.appointmentID = appointmentID;
	    }

	    public String getTechnicianName() {
	        return technicianName;
	    }

	    public void setTechnicianName(String technicianName) {
	        this.technicianName = technicianName;
	    }

	    public String getDoctorName() {
	        return doctorName;
	    }

	    public void setDoctorName(String doctorName) {
	        this.doctorName = doctorName;
	    }

}
