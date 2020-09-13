package com.thoughtworks.capability.gtb.restfulapidesign.exception;

public class ErrorResult {
    private String message;

    public ErrorResult(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
