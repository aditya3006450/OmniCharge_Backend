package com.omincharge.operator.dto;

import jakarta.validation.constraints.NotBlank;

public class OperatorRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Code is required")
    private String code;

    private String logoUrl;

    public String getName() { return name; }
    public String getCode() { return code; }
    public String getLogoUrl() { return logoUrl; }
    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }
    public void setLogoUrl(String logoUrl) { this.logoUrl = logoUrl; }
}