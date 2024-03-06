package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    private List<Payment> paymentData = new ArrayList<>();

    public Payment save(Payment payment) {
        // Cari apakah payment dengan id yang sama sudah ada dalam daftar
        for (int i = 0; i < paymentData.size(); i++) {
            Payment savedPayment = paymentData.get(i);
            if (savedPayment.getId().equals(payment.getId())) {
                // Jika sudah ada, perbarui data payment yang ada
                paymentData.set(i, payment);
                return payment;
            }
        }
        // Jika payment dengan id yang sama tidak ditemukan, tambahkan ke daftar
        paymentData.add(payment);
        return payment;
    }

    public Payment findById(String id) {
        // Cari payment berdasarkan id
        for (Payment savedPayment : paymentData) {
            if (savedPayment.getId().equals(id)) {
                return savedPayment;
            }
        }
        // Jika tidak ditemukan, kembalikan null
        return null;
    }
}
