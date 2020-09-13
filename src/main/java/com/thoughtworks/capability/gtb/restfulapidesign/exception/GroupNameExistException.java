package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import com.thoughtworks.capability.gtb.restfulapidesign.common.constants.ExceptionConstants;

public class GroupNameExistException extends Exception {
    private String message = ExceptionConstants.GROUP_NAME_EXIST;

    public GroupNameExistException() {
    }

    @Override
    public String getMessage() {
        return message;
    }
}
