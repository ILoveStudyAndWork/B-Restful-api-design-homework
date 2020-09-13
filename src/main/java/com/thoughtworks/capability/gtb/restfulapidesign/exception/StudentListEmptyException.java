package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import com.thoughtworks.capability.gtb.restfulapidesign.common.constants.ExceptionConstants;

public class StudentListEmptyException extends Exception {
    private String message = ExceptionConstants.STUDENT_LIST_EMPTY;

    public StudentListEmptyException() {
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
