package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PaymentServiceTest {
    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddPayment() {
        // Arrange
        Order order = new Order();
        String method = "Bank Transfer";
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", "Example Bank");
        paymentData.put("referenceCode", "123456789");

        // Act
        Payment payment = paymentService.addPayment(order, method, paymentData);

        // Assert
        assertEquals(method, payment.getMethod());
        assertEquals("WAITING", payment.getStatus());
        assertEquals(paymentData, payment.getPaymentData());
        verify(paymentRepository, times(1)).save(payment);
    }
}
