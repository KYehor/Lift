package com.denovoapp.exceptions;

import javax.management.OperationsException;

public class LiftCapacityOrNotCorrectFloorException extends IllegalArgumentException {
    public LiftCapacityOrNotCorrectFloorException(String message){
        super(message);
    }
}
