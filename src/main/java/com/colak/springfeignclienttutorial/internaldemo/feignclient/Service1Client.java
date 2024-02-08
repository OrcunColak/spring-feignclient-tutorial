package com.colak.springfeignclienttutorial.internaldemo.feignclient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "service1Client", url = "http://localhost:8080", path = "/api/service1")
public interface Service1Client {
    Logger log = LoggerFactory.getLogger(Service1Client.class);

    @GetMapping(path = "/getQuote/{id}")
    @Retry(name = "service1Retry")
    @CircuitBreaker(name = "service1CircuitBreaker", fallbackMethod = "service1FallbackMethod")
    ResponseEntity<Service1Response> getQuote(@PathVariable("id") int id);

    default ResponseEntity<Service1Response> service1FallbackMethod(int id, Throwable exception) {
        Service1Response service1Response = new Service1Response();
        service1Response.setMsg("Service 1 default message");
        return ResponseEntity.ok(service1Response);
    }
}
