package abc.laboratory.webapp.Model;


import java.sql.Date;

public class Appointment {
    private int appointmentID;
    private String appointmentDate;
    private String doctorName;
    private String checkupName;
    private String labWorkerName;
    private int patientID;
    private int checkupID;
    private int doctorID;
    private int labWorkerID;
    private String appointmentStatus;

    public Appointment(int appointmentID, String appointmentDate, String doctorName, String checkupName, String labWorkerName, int patientID, int checkupID, int doctorID, int labWorkerID, String appointmentStatus) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
        this.checkupName = checkupName;
        this.labWorkerName = labWorkerName;
        this.patientID = patientID;
        this.checkupID = checkupID;
        this.doctorID = doctorID;
        this.labWorkerID = labWorkerID;
        this.appointmentStatus = appointmentStatus;
    }
    public Appointment( String appointmentDate, String doctorName, String checkupName, String labWorkerName, int patientID, int checkupID, int doctorID, int labWorkerID, String appointmentStatus) {
        
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
        this.checkupName = checkupName;
        this.labWorkerName = labWorkerName;
        this.patientID = patientID;
        this.checkupID = checkupID;
        this.doctorID = doctorID;
        this.labWorkerID = labWorkerID;
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

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getCheckupName() {
        return checkupName;
    }

    public void setCheckupName(String checkupName) {
        this.checkupName = checkupName;
    }

    public String getLabWorkerName() {
        return labWorkerName;
    }

    public void setLabWorkerName(String labWorkerName) {
        this.labWorkerName = labWorkerName;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getCheckupID() {
        return checkupID;
    }

    public void setCheckupID(int checkupID) {
        this.checkupID = checkupID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getLabWorkerID() {
        return labWorkerID;
    }

    public void setLabWorkerID(int labWorkerID) {
        this.labWorkerID = labWorkerID;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
}

