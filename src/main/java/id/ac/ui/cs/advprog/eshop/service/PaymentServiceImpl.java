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
        Payment payment = new Payment();
        payment.setId(generatePaymentId());
        payment.setMethod(method);
        payment.setStatus("WAITING");
        payment.setPaymentData(paymentData);
        return paymentRepository.save(payment);
    }
}
