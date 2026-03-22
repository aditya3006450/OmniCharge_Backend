package com.omincharge.recharge.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "recharge_requests")
public class RechargeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long operatorId;

    @Column(nullable = false)
    private Long planId;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    private String failureReason;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) this.status = Status.PENDING;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public enum Status {
        PENDING, PROCESSING, COMPLETED, FAILED
    }

    // Getters
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Long getOperatorId() { return operatorId; }
    public Long getPlanId() { return planId; }
    public String getPhoneNumber() { return phoneNumber; }
    public BigDecimal getAmount() { return amount; }
    public Status getStatus() { return status; }
    public String getFailureReason() { return failureReason; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setOperatorId(Long operatorId) { this.operatorId = operatorId; }
    public void setPlanId(Long planId) { this.planId = planId; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setStatus(Status status) { this.status = status; }
    public void setFailureReason(String failureReason) { this.failureReason = failureReason; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    // Builder
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private RechargeRequest r = new RechargeRequest();
        public Builder userId(Long userId) { r.userId = userId; return this; }
        public Builder operatorId(Long operatorId) { r.operatorId = operatorId; return this; }
        public Builder planId(Long planId) { r.planId = planId; return this; }
        public Builder phoneNumber(String phoneNumber) { r.phoneNumber = phoneNumber; return this; }
        public Builder amount(BigDecimal amount) { r.amount = amount; return this; }
        public Builder status(Status status) { r.status = status; return this; }
        public RechargeRequest build() { return r; }
    }
}