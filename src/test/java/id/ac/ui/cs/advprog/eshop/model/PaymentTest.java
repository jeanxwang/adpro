package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentTest {
    private Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        this.paymentData = new HashMap<>();
        paymentData.put("bankName", "Example Bank");
        paymentData.put("referenceCode", "123456789");
    }

    @Test
    void testCreatePayment() {
        Payment payment = new Payment();
        payment.setId("123456");
        payment.setMethod("Bank Transfer");
        payment.setStatus("WAITING");
        payment.setPaymentData(paymentData);

        assertEquals("123456", payment.getId());
        assertEquals("Bank Transfer", payment.getMethod());
        assertEquals("WAITING", payment.getStatus());
        assertEquals(paymentData, payment.getPaymentData());
    }
}
