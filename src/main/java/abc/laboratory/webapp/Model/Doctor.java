package abc.laboratory.webapp.Model;

public class Doctor {
    private int doctorID;
    private String firstName;
    private String lastName;
    private String specialization;
    private String email;

    public Doctor(int doctorID, String firstName, String lastName, String specialization, String email) {
        this.doctorID = doctorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.email = email;
    }

    public Doctor(String firstName, String lastName, String specialization, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.email = email;
    }

    public Doctor() {
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}