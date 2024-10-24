package com.colak.springtutorial.internaldemo.feignclient.errordecoder;

public class ExternalServiceException extends RuntimeException {

    public ExternalServiceException(String message) {
        super(message);
    }
}