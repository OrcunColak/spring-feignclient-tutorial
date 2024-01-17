package com.colak.springfeignclienttutorial.feignclient.errordecoder;

public class ExternalServiceException extends RuntimeException {

    public ExternalServiceException(String message) {
        super(message);
    }
}