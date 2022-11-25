package com.cgi.bni.spring3demo.controller;

import com.cgi.bni.spring3demo.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ProblemDetail handleNotFound(EmployeeNotFoundException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                exception.getMessage());
        problemDetail.setProperty("EmployeeId", exception.getEmployeeId());
        problemDetail.setProperty("bar", "foo");
        problemDetail.setType(URI.create("https://confluence"));
        return problemDetail;
    }

//    @ExceptionHandler(EmployeeNotFoundException.class)
//    public ProblemDetail handleNotFound(EmployeeNotFoundException exception) {
//        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
//                exception.getMessage());
//    }
}
