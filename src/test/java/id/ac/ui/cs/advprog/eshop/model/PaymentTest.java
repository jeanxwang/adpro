package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    @Test
    void testCreatePayment() {
        // Arrange
        String id = "123456";
        String method = "Bank Transfer";
        String status = "WAITING";
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", "Example Bank");
        paymentData.put("referenceCode", "123456789");

        // Act
        Payment payment = new Payment(id, method, status, paymentData);

        // Assert
        assertEquals(id, payment.getId());
        assertEquals(method, payment.getMethod());
        assertEquals(status, payment.getStatus());
        assertEquals(paymentData, payment.getPaymentData());
    }

    @Test
    void testSetStatusValid() {
        // Arrange
        Payment payment = new Payment("123456", "Bank Transfer", "WAITING", new HashMap<>());

        // Act
        payment.setStatus("SUCCESS");

        // Assert
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testSetStatusInvalid() {
        // Arrange
        Payment payment = new Payment("123456", "Bank Transfer", "WAITING", new HashMap<>());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("INVALID_STATUS"));
    }
}
