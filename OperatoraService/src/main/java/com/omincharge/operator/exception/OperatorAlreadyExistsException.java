package com.omincharge.operator.exception;

public class OperatorAlreadyExistsException extends RuntimeException {
    public OperatorAlreadyExistsException(String message) {
        super(message);
    }
}