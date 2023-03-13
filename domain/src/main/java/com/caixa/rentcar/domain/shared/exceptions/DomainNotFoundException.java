package com.caixa.rentcar.domain.shared.exceptions;

public class DomainNotFoundException extends RuntimeException {
    public DomainNotFoundException(String message) {
        super(message);
    }

    public DomainNotFoundException(String format, Object... objects) {
        super(String.format(format, objects));
    }
}
