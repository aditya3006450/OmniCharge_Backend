package com.omincharge.recharge.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recharge_history")
public class RechargeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long rechargeId;

    @Column(nullable = false)
    private String status;

    private String message;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @PrePersist
    public void prePersist() {
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public Long getId() { return id; }
    public Long getRechargeId() { return rechargeId; }
    public String getStatus() { return status; }
    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setRechargeId(Long rechargeId) { this.rechargeId = rechargeId; }
    public void setStatus(String status) { this.status = status; }
    public void setMessage(String message) { this.message = message; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    // Builder
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private RechargeHistory h = new RechargeHistory();
        public Builder rechargeId(Long rechargeId) { h.rechargeId = rechargeId; return this; }
        public Builder status(String status) { h.status = status; return this; }
        public Builder message(String message) { h.message = message; return this; }
        public RechargeHistory build() { return h; }
    }
}