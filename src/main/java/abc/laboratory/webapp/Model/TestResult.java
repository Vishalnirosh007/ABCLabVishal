package abc.laboratory.webapp.Model;

public class TestResult {
    private int resultID; // Corresponds to ResultID column
    private int appointmentID; // Corresponds to AppointmentID column
    private String result; // Corresponds to Result column
    private byte[] report; // Corresponds to Report column

    public TestResult(int resultID, int appointmentID, String result, byte[] report) {
        this.resultID = resultID;
        this.appointmentID = appointmentID;
        this.result = result;
        this.report = report;
    }

    public TestResult(int appointmentID, String result, byte[] report) {
        this.appointmentID = appointmentID;
        this.result = result;
        this.report = report;
    }

    public TestResult() {
        // Default constructor
    }

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public byte[] getReport() {
        return report;
    }

    public void setReport(byte[] report) {
        this.report = report;
    }
}
