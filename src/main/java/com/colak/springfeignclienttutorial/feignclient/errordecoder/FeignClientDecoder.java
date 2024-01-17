package com.colak.springfeignclienttutorial.feignclient.errordecoder;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class FeignClientDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String feignClientClassName, Response response) {
        if (response.status() >= HttpStatus.BAD_REQUEST.value()
            && response.status() < HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            log.error(
                    "FeignClientErrorDecoder response received for feign client {} with response: {}",
                    feignClientClassName,
                    response);
                return new ExternalServiceException("Bad Response from external services");
        }
        return defaultErrorDecoder.decode(feignClientClassName, response);
    }
}
