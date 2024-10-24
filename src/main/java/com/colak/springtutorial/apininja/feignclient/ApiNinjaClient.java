package com.colak.springtutorial.apininja.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * See <a href="https://medium.com/@karthik.jeyapal/integrations-in-spring-boot-with-feignclient-8cc8a06f0e5b">...</a>
 * This is just an example that shows how to use @RequestParam and @RequestHeader
 */
@FeignClient(value = "apiNinjaQuoteClient", url = "https://api.api-ninjas.com/v1/quotes")
public interface ApiNinjaClient {

    // category = fear
    // token = api-key
    @GetMapping
    List<QuoteResponse> generateQuote(@RequestParam String category, @RequestHeader("X-Api-Key") String token);

}
