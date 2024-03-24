package abc.laboratory.webapp.Model;


public class Appointment {
    private int appointmentID;
    private int patientID;
    private String appointmentDate;
    private String checkupName;
    private String doctorName;
    private String appointmentStatus;
    
    public Appointment(int appointmentID, int patientID, String appointmentDate, String checkupName, String doctorName, String appointmentStatus) {
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.appointmentDate = appointmentDate;
        this.checkupName = checkupName;
        this.doctorName = doctorName;
        this.appointmentStatus = appointmentStatus;
    }
    
    public Appointment(int patientID, String appointmentDate, String checkupName, String doctorName, String appointmentStatus) {
        this.patientID = patientID;
        this.appointmentDate = appointmentDate;
        this.checkupName = checkupName;
        this.doctorName = doctorName;
        this.appointmentStatus = appointmentStatus;
    }

    public Appointment() {
        
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getCheckupName() {
        return checkupName;
    }

    public void setCheckupName(String checkupName) {
        this.checkupName = checkupName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
}
