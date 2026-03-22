package com.omincharge.payment.controller;

import com.omincharge.payment.dto.*;
import com.omincharge.payment.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<PaymentResponse> processPayment(
            @Valid @RequestBody PaymentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paymentService.processPayment(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getTransactionById(
            @PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getTransactionById(id));
    }

    @GetMapping("/ref/{ref}")
    public ResponseEntity<PaymentResponse> getTransactionByRef(
            @PathVariable String ref) {
        return ResponseEntity.ok(paymentService.getTransactionByRef(ref));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PaymentResponse>> getTransactionsByUser(
            @PathVariable Long userId) {
        return ResponseEntity.ok(paymentService.getTransactionsByUser(userId));
    }

    @GetMapping("/recharge/{rechargeId}")
    public ResponseEntity<List<PaymentResponse>> getTransactionsByRecharge(
            @PathVariable Long rechargeId) {
        return ResponseEntity.ok(
            paymentService.getTransactionsByRecharge(rechargeId));
    }
}