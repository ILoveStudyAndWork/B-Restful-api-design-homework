package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import com.thoughtworks.capability.gtb.restfulapidesign.common.constants.ExceptionConstants;

public class RequestGroupNameEmptyException extends Exception {
    private String message = ExceptionConstants.REQUEST_GROUP_NAME_EMPTY;

    public RequestGroupNameEmptyException() {
    }

    @Override
    public String getMessage() {
        return message;
    }
}
