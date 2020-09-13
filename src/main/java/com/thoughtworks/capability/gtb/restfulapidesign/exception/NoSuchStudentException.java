package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import com.thoughtworks.capability.gtb.restfulapidesign.common.constants.ExceptionConstants;

public class NoSuchStudentException extends Exception {
    private String message = ExceptionConstants.NO_SUCH_STUDENT;

    public NoSuchStudentException() {
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
