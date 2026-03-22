package com.omincharge.operator.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "recharge_plans")
public class RechargePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operator_id", nullable = false)
    private Operator operator;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private Integer validityDays;

    private String dataAllowance;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @PrePersist
    public void prePersist() {
        if (this.status == null) this.status = Status.ACTIVE;
    }

    public enum Status { ACTIVE, INACTIVE }

    // Getters
    public Long getId() { return id; }
    public Operator getOperator() { return operator; }
    public String getName() { return name; }
    public BigDecimal getAmount() { return amount; }
    public Integer getValidityDays() { return validityDays; }
    public String getDataAllowance() { return dataAllowance; }
    public String getDescription() { return description; }
    public Status getStatus() { return status; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setOperator(Operator operator) { this.operator = operator; }
    public void setName(String name) { this.name = name; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setValidityDays(Integer validityDays) { this.validityDays = validityDays; }
    public void setDataAllowance(String dataAllowance) { this.dataAllowance = dataAllowance; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(Status status) { this.status = status; }

    // Builder
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private RechargePlan p = new RechargePlan();
        public Builder operator(Operator operator) { p.operator = operator; return this; }
        public Builder name(String name) { p.name = name; return this; }
        public Builder amount(BigDecimal amount) { p.amount = amount; return this; }
        public Builder validityDays(Integer validityDays) { p.validityDays = validityDays; return this; }
        public Builder dataAllowance(String dataAllowance) { p.dataAllowance = dataAllowance; return this; }
        public Builder description(String description) { p.description = description; return this; }
        public Builder status(Status status) { p.status = status; return this; }
        public RechargePlan build() { return p; }
    }
}