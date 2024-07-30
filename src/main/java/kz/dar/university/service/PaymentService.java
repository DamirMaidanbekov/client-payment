package kz.dar.university.service;

import kz.dar.university.model.PaymentModel;
import kz.dar.university.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentModel savePayment(PaymentModel paymentModel) {
        return paymentRepository.save(paymentModel);
    }

    public PaymentModel updatePayment(String id, PaymentModel paymentModel) {
        paymentModel.setId(id);
        return paymentRepository.save(paymentModel);
    }

    public PaymentModel getPaymentById(String id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public void deletePaymentById(String id) {
        paymentRepository.deleteById(id);
    }

    public Page<PaymentModel> getAllPayments(int page, int size) {
        return paymentRepository.findAll(PageRequest.of(page, size));
    }
}
