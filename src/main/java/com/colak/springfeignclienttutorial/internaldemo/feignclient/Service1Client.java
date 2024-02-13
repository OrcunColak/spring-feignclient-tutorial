package com.colak.springfeignclienttutorial.internaldemo.feignclient;

import com.colak.springfeignclienttutorial.quote.controller.QuoteResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "service1Client", url = "http://localhost:8080", path = "/api/service1")
public interface Service1Client {

    @GetMapping(path = "/getQuote/{id}")
    @Retry(name = "service1Retry")
    @CircuitBreaker(name = "service1CircuitBreaker", fallbackMethod = "service1FallbackMethod")
    ResponseEntity<QuoteResponse> getQuote(@PathVariable("id") int id);

    default ResponseEntity<QuoteResponse> service1FallbackMethod(int id, Throwable exception) {
        QuoteResponse quoteResponse = new QuoteResponse();
        quoteResponse.setMsg("Service 1 default message");
        return ResponseEntity.ok(quoteResponse);
    }
}
