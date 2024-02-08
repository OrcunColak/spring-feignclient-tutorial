package com.colak.springfeignclienttutorial.internaldemo.feignclient.config;

import com.colak.springfeignclienttutorial.internaldemo.feignclient.errordecoder.FeignClientDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public ErrorDecoder myErrorDecoder() {
        return new FeignClientDecoder();
    }
}
