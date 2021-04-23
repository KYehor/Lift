package com.denovoapp.exceptions;

import javax.management.OperationsException;

public class NotCorrectAmountException extends IllegalArgumentException {
    public NotCorrectAmountException(String message){
        super(message);
    }
}
