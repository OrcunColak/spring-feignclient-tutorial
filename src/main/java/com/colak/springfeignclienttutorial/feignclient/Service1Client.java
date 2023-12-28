package com.colak.springfeignclienttutorial.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service1Client", url = "http://localhost:8080", path = "/api/service1")
public interface  Service1Client {

    @GetMapping( path = "/getQuote/{id}" , produces = "application/json")
    ResponseEntity<Service1Response> getQuote(@PathVariable("id") int id);
}
