package com.omincharge.operator.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "operators")
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String code;

    private String logoUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) this.status = Status.ACTIVE;
    }

    public enum Status { ACTIVE, INACTIVE }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCode() { return code; }
    public String getLogoUrl() { return logoUrl; }
    public Status getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }
    public void setLogoUrl(String logoUrl) { this.logoUrl = logoUrl; }
    public void setStatus(Status status) { this.status = status; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    // Builder
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Operator o = new Operator();
        public Builder name(String name) { o.name = name; return this; }
        public Builder code(String code) { o.code = code; return this; }
        public Builder logoUrl(String logoUrl) { o.logoUrl = logoUrl; return this; }
        public Builder status(Status status) { o.status = status; return this; }
        public Operator build() { return o; }
    }
}