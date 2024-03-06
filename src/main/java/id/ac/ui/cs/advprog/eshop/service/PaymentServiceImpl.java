package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        String id = generatePaymentId();
        Payment payment = new Payment(id, method, "WAITING", paymentData);
        return paymentRepository.save(payment);
    }

    public Payment setStatus(String paymentId, String status) {
        Payment payment = paymentRepository.findById(paymentId);
        if (payment == null) {
            throw new IllegalArgumentException("Payment not found");
        }
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }

    public Payment getPayment(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    public String generatePaymentId() {
        return "PAYMENT-" + System.currentTimeMillis();
    }
}
