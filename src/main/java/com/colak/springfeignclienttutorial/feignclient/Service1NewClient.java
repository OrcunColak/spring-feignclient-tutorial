package com.colak.springfeignclienttutorial.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;

@FeignClient(name = "service1NewClient", url = "https://this-is-a-placeholder.com")
public interface Service1NewClient {

    @GetMapping( path = "/getQuote/{id}" , produces = "application/json")
    ResponseEntity<Service1Response> getQuote(URI baseUrl,@PathVariable("id") int id);
}
