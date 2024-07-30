package kz.dar.university.controller;

import jakarta.validation.Valid;
import kz.dar.university.model.PaymentModel;
import kz.dar.university.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentModel> createPayment(@RequestBody @Valid PaymentModel paymentModel) {
        PaymentModel savedPayment = paymentService.savePayment(paymentModel);
        return ResponseEntity.ok(savedPayment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentModel> getPaymentById(@PathVariable String id) {
        PaymentModel paymentModel = paymentService.getPaymentById(id);
        if (paymentModel != null) {
            return ResponseEntity.ok(paymentModel);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentModel> updatePayment(@PathVariable String id, @RequestBody @Valid PaymentModel paymentModel) {
        PaymentModel updatedPayment = paymentService.updatePayment(id, paymentModel);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentById(@PathVariable String id) {
        paymentService.deletePaymentById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<PaymentModel>> getAllPayments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<PaymentModel> paymentPage = paymentService.getAllPayments(page, size);
        return ResponseEntity.ok(paymentPage);
    }
}

