package com.cgi.bni.spring3demo.exception;

import lombok.Getter;

@Getter
public class EmployeeNotFoundException extends RuntimeException {

    private final long employeeId;
    private final String message;

    public EmployeeNotFoundException(long employeeId, String message) {
        super(message);
        this.employeeId = employeeId;
        this.message = message;
    }

}
