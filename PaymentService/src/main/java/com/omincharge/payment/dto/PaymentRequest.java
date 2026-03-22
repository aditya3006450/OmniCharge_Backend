package com.omincharge.payment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PaymentRequest {

    @NotNull(message = "Recharge ID is required")
    private Long rechargeId;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Payment method is required")
    private String paymentMethod;

    public Long getRechargeId() { return rechargeId; }
    public Long getUserId() { return userId; }
    public String getPaymentMethod() { return paymentMethod; }

    public void setRechargeId(Long rechargeId) { this.rechargeId = rechargeId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}