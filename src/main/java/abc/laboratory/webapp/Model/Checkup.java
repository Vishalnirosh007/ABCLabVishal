package abc.laboratory.webapp.Model;

public class Checkup {
    private int checkupID;
    private String checkupName;
    private double checkupCost;
    private String checkupDescription;

    public Checkup(int checkupID, String checkupName, double checkupCost, String checkupDescription) {
        this.checkupID = checkupID;
        this.checkupName = checkupName;
        this.checkupCost = checkupCost;
        this.checkupDescription = checkupDescription;
    }

    public Checkup(String checkupName, double checkupCost, String checkupDescription) {
        this.checkupName = checkupName;
        this.checkupCost = checkupCost;
        this.checkupDescription = checkupDescription;
    }

    public Checkup() {

    }

    public int getCheckupID() {
        return checkupID;
    }

    public void setCheckupID(int checkupID) {
        this.checkupID = checkupID;
    }

    public String getCheckupName() {
        return checkupName;
    }

    public void setCheckupName(String checkupName) {
        this.checkupName = checkupName;
    }

    public double getCheckupCost() {
        return checkupCost;
    }

    public void setCheckupCost(double checkupCost) {
        this.checkupCost = checkupCost;
    }

    public String getCheckupDescription() {
        return checkupDescription;
    }

    public void setCheckupDescription(String checkupDescription) {
        this.checkupDescription = checkupDescription;
    }
}