package com.omincharge.payment.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long rechargeId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(unique = true, nullable = false)
    private String transactionRef;

    private String failureReason;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) this.status = Status.PENDING;
        if (this.transactionRef == null)
            this.transactionRef = "TXN-" + UUID.randomUUID()
                .toString().toUpperCase().replace("-", "").substring(0, 12);
    }

    public enum PaymentMethod {
        UPI, CREDIT_CARD, DEBIT_CARD, NET_BANKING, WALLET
    }

    public enum Status {
        PENDING, SUCCESS, FAILED
    }

    // Getters
    public Long getId() { return id; }
    public Long getRechargeId() { return rechargeId; }
    public Long getUserId() { return userId; }
    public BigDecimal getAmount() { return amount; }
    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    public Status getStatus() { return status; }
    public String getTransactionRef() { return transactionRef; }
    public String getFailureReason() { return failureReason; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setRechargeId(Long rechargeId) { this.rechargeId = rechargeId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setPaymentMethod(PaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }
    public void setStatus(Status status) { this.status = status; }
    public void setTransactionRef(String transactionRef) { this.transactionRef = transactionRef; }
    public void setFailureReason(String failureReason) { this.failureReason = failureReason; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    // Builder
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Transaction t = new Transaction();
        public Builder rechargeId(Long rechargeId) { t.rechargeId = rechargeId; return this; }
        public Builder userId(Long userId) { t.userId = userId; return this; }
        public Builder amount(BigDecimal amount) { t.amount = amount; return this; }
        public Builder paymentMethod(PaymentMethod paymentMethod) { t.paymentMethod = paymentMethod; return this; }
        public Builder status(Status status) { t.status = status; return this; }
        public Transaction build() { return t; }
    }
}