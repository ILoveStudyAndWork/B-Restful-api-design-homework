package com.thoughtworks.capability.gtb.restfulapidesign.component;

import com.thoughtworks.capability.gtb.restfulapidesign.exception.ErrorResult;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentListEmptyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentListEmptyException.class)
    public ResponseEntity<ErrorResult> handle(StudentListEmptyException ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.badRequest().body(errorResult);
    }}
