package abc.laboratory.webapp.Model;


public class Payment {
    private int paymentId;
    private double price;
    private String cardholderName;
    private int cardNumber;
    private String expiryDate;
    private int cvcNumber;
    private String paymentDate;
    private int patientId;

    public Payment(int paymentId, double price, String cardholderName, int cardNumber, String expiryDate, int cvcNumber, String paymentDate, int patientId) {
        this.paymentId = paymentId;
        this.price = price;
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvcNumber = cvcNumber;
        this.paymentDate = paymentDate;
        this.patientId = patientId;
    }

    public Payment(double price, String cardholderName, int cardNumber, String expiryDate, int cvcNumber, String paymentDate, int patientId) {
        this.price = price;
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvcNumber = cvcNumber;
        this.paymentDate = paymentDate;
        this.patientId = patientId;
    }

    public Payment() {
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvcNumber() {
        return cvcNumber;
    }

    public void setCvcNumber(int cvcNumber) {
        this.cvcNumber = cvcNumber;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}
