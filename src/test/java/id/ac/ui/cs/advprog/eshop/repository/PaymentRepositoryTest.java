package id.ac.ui.cs.advprog.eshop.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentRepositoryTest {
    private PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();
    }

    @Test
    void testSavePayment() {
        // Arrange
        String id = "123456";
        String method = "Bank Transfer";
        String status = "WAITING";
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", "Example Bank");
        paymentData.put("referenceCode", "123456789");
        Payment payment = new Payment(id, method, status, paymentData);

        // Act
        Payment savedPayment = paymentRepository.save(payment);

        // Assert
        assertEquals(payment, savedPayment);
    }

    @Test
    void testFindById() {
        // Arrange
        String id = "123456";
        String method = "Bank Transfer";
        String status = "WAITING";
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", "Example Bank");
        paymentData.put("referenceCode", "123456789");
        Payment payment = new Payment(id, method, status, paymentData);
        paymentRepository.save(payment);

        // Act
        Payment foundPayment = paymentRepository.findById(id);

        // Assert
        assertEquals(payment, foundPayment);
    }

    @Test
    void testFindByIdNotFound() {
        // Arrange
        String id = "123456";

        // Act
        Payment foundPayment = paymentRepository.findById(id);

        // Assert
        assertNull(foundPayment);
    }

    @Test
    void testFindAll() {
        // Arrange
        Payment payment1 = new Payment("1", "Method 1", "SUCCESS", new HashMap<>());
        Payment payment2 = new Payment("2", "Method 2", "REJECTED", new HashMap<>());
        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

        // Act
        List<Payment> payments = paymentRepository.findAll();

        // Assert
        assertEquals(2, payments.size());
        assertTrue(payments.contains(payment1));
        assertTrue(payments.contains(payment2));
    }
}
