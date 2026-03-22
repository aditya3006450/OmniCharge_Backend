package com.omincharge.recharge.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class RechargeInitiateRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Operator ID is required")
    private Long operatorId;

    @NotNull(message = "Plan ID is required")
    private Long planId;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$",
             message = "Phone number must be 10 digits")
    private String phoneNumber;

    public Long getUserId() { return userId; }
    public Long getOperatorId() { return operatorId; }
    public Long getPlanId() { return planId; }
    public String getPhoneNumber() { return phoneNumber; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setOperatorId(Long operatorId) { this.operatorId = operatorId; }
    public void setPlanId(Long planId) { this.planId = planId; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}