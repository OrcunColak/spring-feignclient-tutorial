package com.colak.springtutorial.internaldemo.feignclient;

import com.colak.springtutorial.quote.controller.QuoteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;

@FeignClient(name = "service2Client", url = "https://this-is-a-placeholder.com")
public interface Service2Client {

    @GetMapping( path = "/getQuote/{id}" , produces = "application/json")
    ResponseEntity<QuoteResponse> getQuote(URI baseUrl, @PathVariable("id") int id);
}
