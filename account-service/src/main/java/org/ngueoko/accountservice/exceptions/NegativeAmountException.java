package org.ngueoko.accountservice.exeption;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(String format) {
        super(format);
    }
}
