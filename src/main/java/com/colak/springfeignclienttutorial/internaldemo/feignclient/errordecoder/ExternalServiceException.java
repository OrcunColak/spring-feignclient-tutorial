package com.colak.springfeignclienttutorial.internaldemo.feignclient.errordecoder;

public class ExternalServiceException extends RuntimeException {

    public ExternalServiceException(String message) {
        super(message);
    }
}