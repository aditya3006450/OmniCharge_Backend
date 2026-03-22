package com.omincharge.recharge.exception;

public class RechargeNotFoundException extends RuntimeException {
    public RechargeNotFoundException(String message) {
        super(message);
    }
}