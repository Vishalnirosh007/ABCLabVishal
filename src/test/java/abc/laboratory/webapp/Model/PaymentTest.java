package abc.laboratory.webapp.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PaymentTest {

    @Test
    void testGettersAndSetters() {
        Payment payment = new Payment();
        
        payment.setPaymentId(1);
        assertEquals(1, payment.getPaymentId());
        
        payment.setPrice(100.0);
        assertEquals(100.0, payment.getPrice());
        
        payment.setCardholderName("Vishal Nirosh");
        assertEquals("John Doe", payment.getCardholderName());
        
        payment.setCardNumber(1234567890);
        assertEquals(1234567890, payment.getCardNumber());
        
        payment.setExpiryDate("12/25");
        assertEquals("12/25", payment.getExpiryDate());
        
        payment.setCvcNumber(123);
        assertEquals(123, payment.getCvcNumber());
        
        payment.setPaymentDate("2024-03-30");
        assertEquals("2024-03-30", payment.getPaymentDate());
        
        payment.setPatientId(2);
        assertEquals(2, payment.getPatientId());
    }
    
    @Test
    void testConstructors() {
        Payment payment = new Payment(1, 100.0, "Vishal Nirosh", 1234567890, "12/25", 123, "2024-03-30", 2);
        
        assertEquals(1, payment.getPaymentId());
        assertEquals(100.0, payment.getPrice());
        assertEquals("John Doe", payment.getCardholderName());
        assertEquals(1234567890, payment.getCardNumber());
        assertEquals("12/25", payment.getExpiryDate());
        assertEquals(123, payment.getCvcNumber());
        assertEquals("2024-03-30", payment.getPaymentDate());
        assertEquals(2, payment.getPatientId());
    }
}
